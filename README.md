# ***Design Patterns***

## Sobre

Design patterns são padrões codificação existentes em projetos. Eles foram criados direcionados a projetos desenvolvidos no paradigma ***Orientado a Objeto***, principalmente porque existiam problemas nos códigos que eram sempre resolvidos da mesma maneira. Dessa forma e consequentemente eles ajudam na limpeza do código e mantenabilidade do projeto, tornando-o menos sucetível a erros.

## Tipos de padão de projeto

Os padões de projeto, depois de definidos, foram separados em 4 categorias principais.

- ***Creational Patterns*** (Padrões de Criação)
- ***Structural Pattern***s (Padrões de Estruturação)
- ***Behavioral Patterns*** (Padrões de Comportamento)
- ***J2EE Patterns***

### Creational Patterns

São os padrões que ***disponibilizam formas de criação de entidades***. Eles evitam que você precise ficar criando novos objetos diretamente pelo construtor (utilizando o operador *new*), e lidam com a lógica de construção de determinado objeto para determinado contexto. 

Neste artigo veremos os seguintes padrões criacionais:

- ***Singleton***
- ***Factory***
- ***Builder***

### Structural Patterns

São padrões de projeto que ***facilitam o relacionamento entre entidades***. Os conceitos de herança e interface são muito utilizados para compor objetos com funcionalidades novas. 

Neste artigo veremos os seguintes padrões estruturais:

- ***Adapter***

### Behavioral Patterns

São padrões de projeto que ***lidam com o comportamento e comunicação entre as entidades*** do projeto. 

Neste artigo veremos os seguintes padrões comportamentais:

- ***Observer***
- ***State***

## Implementação e definições

### Creational

#### Singleton

![](./singleton.png)

A idéia do sigleton é que tenhamos uma classe-objeto que pode ser intanciada ***apenas uma vez***, com visibilidade e acesso global a essa instância. Você pode verificar melhor no diagrama abaixo: 

![](./singleton-uml.png)

Para implementar o singleton, você precisa criar uma classe, em que um de seus atributos é uma ***instância privada estática da própria classe***.


```java
/** * This class represents an object with the singleton design pattern */
public class SingletonObject {    
    /**     
    * It has the attribute <b>instance</b> that is the only instance created of this object in the project scope     
    */    
    private static SingletonObject instance;    
```



Depois de criar essa classe, para que o singleton realmente aconteça, você deve impossibilitar a criação de novas instâncias da classe. Para isso, será implementado um contrutor padrão vazio e ***iremos alterar o acesso dele para privado***.


```java
/** 
* This class represents an object with the singleton design pattern 
*/
public class SingletonObject {    
    
    /**     
    * It has the attribute <b>instance</b> that is the only instance created of this object     
    */    
    private static SingletonObject instance;    
    
    //TODO: You can put other attributes here as you wish, but it cannot infer in the pattern. 
    
    /**     
    * A private empty constructor so it is not possible to create another instance of this object     
    */    
    private SingletonObject(){}
}

```


E agora você deve estar se perguntando "se eu alterei o meu construtor para privado, como devo acessar a instância da classe já que ela também é privada?". A resposta é simples: você irá **criar o método _getInstance()_**, que irá te dar acesso à instância da classe e somente ela.

A implementação do método é a seguinte: 


```java
/** 
* The method <i>getInstance()</i> is the only way you can access the <b>single instance</b> of the object 
* @return th single instance possible of an object 
*/
public static SingletonObject getInstance(){    
    if (instance == null) {        
        instance = new SingletonObject();    
    } else{ 
        System.out.println("Uses already created instance."); 
    }
    
    return instance;
}
```


Agora você só precisa adicioná-lo a sua classe e você terá agora um objto singleton dessa forma:


```java
public static void main(String[] args){    
    System.out.println("Starts demonstration of the design patterns implementation and functions.\nYou can debug the code if you want to see line by line.");    
       
    SingletonObject fistCall = SingletonObject.getInstance();
    SingletonObject secondCall = SingletonObject.getInstance();
}
```


O Output será: 

`Starts demonstration of the design patterns implementation and functions.
You can debug the code if you want to see line by line.
Creates the new instance because it is required for the first time
Uses already created instance.`

#### Factory

![](./factory.png)

Factory é o padrão que fornece a possibilidade de criarmos uma ***fabrica para criação dos nossos objetos em tempo de execução***, deixando o cliente isento de instanciar a classe ganhando um dinamismo para a aplicação. O diagrama da sua composição pode ser observado abaixo:

![](./factory-uml.png)



Primeiramente é criada uma classe abstrata que servirá de base para o objeto que quer ser instanciado.

```java
public abstract class BaseClass {    
    private int something;   
    
    public BaseClass(int something){        
        this.something = something;    
    }    
    
    @Override    
    public String toString() {        
        return "BaseClass{" +                
            "something='" + 
            something + 
            '\'' +                
            '}';    
    }
    
    public abstract void doSomething();
}
```



Depois disso, criaremos as classes filhas dessa classe que acabamos de criar, pois é nelas que fazemos a implementação dos métodos abstratos e suas especializações.


```java
public class ImplementationOne extends BaseClass {    
    
    private String someOtherThingHere;    
    
    public ImplementationOne(int something, String someOtherThingHere){
        super(something);        
        this.someOtherThingHere = someOtherThingHere;
        System.out.println("Builds object with ImplementationOne especifications: " + this.someOtherThingHere);
    }    
    
    @Override    
    public void doSomething() {        
        System.out.println("Enters the method doSomething() of ImplementationOne: " + this.someOtherThingHere);    
    }
}
```


```java
public class ImplementationTwo extends BaseClass {    
    
    private String someOtherThingHereToo;    
    
    public ImplementationTwo(int something, String someOtherThingHereToo){        
        super(something);        
        this.someOtherThingHereToo = someOtherThingHereToo;
        System.out.println("Builds object with ImplementationTwo especifications: " + this.someOtherThingHereToo);
    }    
    
    @Override    
    public void doSomething() {        
        System.out.println("Enters the method doSomething() of ImplementationTwo: " + this.someOtherThingHereToo);    
    }
}
```


Agora criaremos a fábrica de objetos. Ela sera uma classe com métodos estáticos. Nesse caso, para exemplo, teremos apenas uma classe.


```java
public class ClassFactory {    
    
    public static BaseClass createClass(int something, String somethingElse){        
        
        switch (something){            
            case 1:                
                return new ImplementationOne(something, somethingElse);            
            case 2:                
                return new ImplementationTwo(something, somethingElse);            
            default:                
                return null;        
        }    
    }
}
```




Pronto. Agora para fazer a criação do método, faremos o seguinte:



```java
public static void main(String[] args){    
    System.out.println("Starts demonstration of the design patterns implementation and functions.\nYou can debug the code if you want to see line by line.");    
    
    int type = 1;    
    String conteudo = "Content 1";    
    ClassFactory.createClass(type, conteudo);    
    
    type = 2;    
    conteudo = "Content 2";        
    ClassFactory.createClass(type, conteudo);

}
```



Fazendo assim, o output seria: 

`Starts demonstration of the design patterns implementation and functions.
You can debug the code if you want to see line by line.
Builds object with ImplementationOne especifications: Content 1
Builds object with ImplementationTwo especifications: Content 2`



#### Builder

![](./builder.png)

O padrão Builder é um padrão de projetos de software comum que é usado para ***encapsular a lógica de construção de um objeto***. Este padrão é frequentemente utilizado quando o processo de construção de um objeto é considerado complexo e também é adequado quando se trata da construção de representações múltiplas de uma mesma classe.

![](./builder-uml.png)



A implementação fica assim:

Primeiro você cria a sua classe complexa já com construtor e todos os atributos que a compõem.


```java
public class ObjectOne {    
    private String attributeOne;    
    private String attributeTwo;    
    
    public ObjectOne(String attributeOne, String attributeTwo){ 
        this.attributeOne = attributeOne;        
        this.attributeTwo = attributeTwo;    
    }
}
```



Ate esse ponto, tudo normal como você já conhecia. 

Agora entramos na parte de realmente implementar o builder. Dentro da própria classe que você acabou de criar, você vai criar uma outra classe publica estática chamada builder. Dentro dela, você vai colocar os mesmos atributos da sua classe de criação.



```java
public class ObjectOne {    
    private String attributeOne;    
    private String attributeTwo;    
    
    public ObjectOne(String attributeOne, String attributeTwo){ 
        this.attributeOne = attributeOne;        
        this.attributeTwo = attributeTwo;    }   
    
    /**     
    * Builder static class is the one who is going to be responsible for the logic to create the object.     
    */    
    public static class Builder {        
        private String attributeOne;        
        private String attributeTwo;        
        
        public Builder(){}        
        
    }
```



Dentro da classe builder é onde serão implementadas as lógicas de criação daquele determinado objeto. 




```java
/** 
* Builder static class is the one who is going to be responsible for the logic to create the object. 
*/
public static class Builder {    
    private String attributeOne;    
    private String attributeTwo;    
    
    public Builder(){}    
    
    public Builder setAttributeOne(String attributeOne){ 
        this.attributeOne = attributeOne;
        System.out.println("Sets attribute one: " + attributeOne);
        return this;    
    }    
    
    public Builder setAttributeTwo(String attributeTwo){ 
        this.attributeTwo = attributeTwo;
        System.out.println("Sets attribute Two: " + attributeTwo);
        return this;    
    }    
    
    public ObjectOne build(){
        System.out.println("Finnaly builds Object");
        return new ObjectOne(attributeOne, attributeTwo);    
    }
}
```



Pronto. O uso do método ficaria:



```java
public static void main(String[] args){    
    System.out.println("Starts demonstration of the design patterns implementation and functions.\nYou can debug the code if you want to see line by line.");    
    
    ObjectOne objectOne = new ObjectOne.Builder()            
        .setAttributeOne("AttributeOne Here")            
        .setAttributeTwo("AttributeTwo here")            
        .build();
}
```



E a saída desse método é:

`Starts demonstration of the design patterns implementation and functions.
You can debug the code if you want to see line by line.
Sets attribute one: AttributeOne Here
Sets attribute Two: AttributeTwo here
Finnaly builds Object`

### Structural

#### Adapter

![](./adapter.png)

O padrão Adapter é muito utilizado quando precisamos encaixar uma nova biblioteca de classes, adquirida de um fornecedor, em um sistema de software já existente, porém essas bibliotecas de classe do novo fornecedor são diferentes das bibliotecas de classes do fornecedor antigo. **O Adapter é muito utilizado para compatibilizar o seu sistema a outros frameworks ou APIs**.

O diagrama UML do adapter é o seguinte:

![](./adapter-uml.png)

Basicamente o que você vai precisar é uma classe com um modelo antigo, e uma classe com o modelo novo. Para fins didáticos, vou criar duas classes aleatórias:

```java
public class OldClass {    
    String oldSomething;    
    
    public OldClass(String oldSomething) {        
        System.out.println("Creates OldClass instance");        
        this.oldSomething = oldSomething;    
    }    
    
    public String getOldSomething() {        
        return oldSomething;    
    }
}
```

```java
public class NewClass {    
    String newSomething;    
    
    public NewClass(String newSomething) {        
        System.out.println("Creates newClass instance");        
        this.newSomething = newSomething;    
    }
}
```

Depois de identificar as duas classes, você precisa criar uma classe adapter, que vai servir de conector entre as duas.

```java
public class OldToNewAdapter {    
    private final OldClass oldClass;    
    
    public OldToNewAdapter(String value){        
        System.out.println("Creates Adapter instance");       
        oldClass = new OldClass(value);    
    }    
    
    public NewClass oldToNew(){        
        System.out.println("Turns old into new. You can do whatever here.");        
        return new NewClass(oldClass.getOldSomething());    
    }
}
```

A utilização do adapter é bem simples:

```java
public static void main(String[] args){    
    System.out.println("Starts demonstration of the design patterns implementation and functions.\nYou can debug the code if you want to see line by line.");    
    
    OldToNewAdapter adapter = new OldToNewAdapter("Another something here");    
    System.out.println(adapter.oldToNew());
}
```

O output seguindo o código acima é:

`Starts demonstration of the design patterns implementation and functions.
You can debug the code if you want to see line by line.
Creates Adapter instance
Creates OldClass instance
Turns old into new. You can do whatever here.
Creates newClass instance
vc.com.justa.adapter.NewClass@60e53b93`

### Behavioral

#### Observer

![](./observer.png)

O padrão Observer é um objeto (Observado) que **permite que outros objetos sejam registrados  como observadores** ou cancelar o seu registro a qualquer momento da aplicação, e ressaltando a ligação leve entre o objeto observado e seus observadores, **com isso os objetos podem interagir, mas não sabem quase nada um sobre o outro,** deixando bem flexível os objetos observadores e observados.

Um exemplo de diagrama UML pode ser observado abaixo:

![](./observer-uml.png)



Para implementar um observer, comece criando o objeto que será alterado. 

```java
/** 
* The subject that is going to be changed in the observer 
*/
public class BaseSubject {    
    private List<ObserverAbstract> observers = new ArrayList<>();    
    private int state;    
    public int getState(){        
        return state;    
    }    
    
    /**     
    * Makes a modification in the subject, so it has to notify all the observables     
    * @param state     
    */    
    public void setState(int state){        
        this.state = state;        
        notifyAllObservers();    
    }    
    
    /**     
    * Attaches a new observer to be notified when the subject changes     
    * @param observer the new observer    
    */    
    public void attach(ObserverAbstract observer){
        System.out.println("Attatched a new Observer");
        observers.add(observer);    
    }    
    
    /**     
    * Notifies and updates all the observables in the list of observables under this subject     */    
    public void notifyAllObservers(){ 
        System.out.println("There was a change. All observers are being notified");
        observers.forEach(ObserverAbstract::update);    
    }
}
```

Crie agora um objeto abstrato que servirá como contrato para os observadores daquele objeto. **Todos eles terão que extender essa classe.**

```java
/** 
* the abstract class that has to be implemented by all the observers who want to be notified in the subject change 
*/public abstract class ObserverAbstract {    
    protected BaseSubject subject;    
    public abstract void update();
}
```

Depois crie os observadores daquele objeto. Você pode criar quantos quiser. Aqui vou criar dois genéricos para fins didáticos.

```java
public class ObserverOne extends ObserverAbstract {    
    public ObserverOne(BaseSubject subject){        
        this.subject = subject;        
        this.subject.attach(this);    
    }    
    
    @Override    
    public void update() 
    {        
        System.out.println("Updates the ObserverOne with the state: " + subject.getState());
    }
}
```

```java
public class ObserverTwo extends ObserverAbstract{    
    
    public ObserverTwo(BaseSubject subject){        
        this.subject = subject;        
        this.subject.attach(this);    
    }    
    
    @Override    
    public void update() {        
        System.out.println("Updates the ObserverTwo with the state: " + subject.getState());
    }
}
```

Agora é só usar. A implementação de uso fica a seguinte:

```java
public static void main(String[] args){    
    System.out.println("Starts demonstration of the design patterns implementation and functions.\nYou can debug the code if you want to see line by line.");    
    
    BaseSubject subject = new BaseSubject();    
    subject.setState(0);    
    
    ObserverOne one = new ObserverOne(subject);    
    ObserverTwo two = new ObserverTwo(subject);    
    
    subject.setState(1);
}
```

E o output para esse código é:

`Starts demonstration of the design patterns implementation and functions.
You can debug the code if you want to see line by line.
There was a change. All observers are being notified
Attatched a new Observer
Attatched a new Observer
There was a change. All observers are being notified
Updates the ObserverOne with the state: 1
Updates the ObserverTwo with the state: 1`

#### State

![](./state.png)

O padrão state **permite que um objeto altere o seu comportamento quando o seu estado interno muda**. O objeto parecerá ter mudado de classe. O padrão encapsula os estados em classes separadas e delega as tarefas  para o objeto que representa o estado atual, nós sabemos que os comportamentos mudam juntamento com o estado interno.

Um exemplo de diagrama UML é mostrado a seguir:

![](./state-uml.png)

Para iniciar a implementaçao, é necessário criar a interface de estado que definirá o contrato dos diferentes estados a serem implementados.

```java
/** 
* Defines the contract that the state has to have 
*/
public interface StateInterface {    
    public void doAction(ContextClass contextClass);
}
```

Depois disso, crie a classe do contexto, que armazenará o estado atual do contexto.

```java
/** 
* The context where the states are 
*/
public class ContextClass {    
    private StateInterface stateInterface;    
    
    public ContextClass(){        
        stateInterface = null;    
    }    
    
    public StateInterface getState() {        
        return stateInterface;    
    }    
    
    /**     
    * Change the state of that determined context     
    * @param stateInterface the new state     
    */    
    public void setState(StateInterface stateInterface) {        
        this.stateInterface = stateInterface;        
        System.out.println(String.format("State of the context %s changed to: %s", this.toString(), stateInterface.toString()));    
    }
}
```

Depois crie os diversos estados. Vou criar apenas dois para fins didiáticos.

```java
/** 
* One implementation of the StateInterface 
*/
public class StateOne implements StateInterface {    
    
    @Override    
    public void doAction(ContextClass contextClass) {        
        contextClass.setState(this);        
        System.out.println("The state now is 1 in the context: " + contextClass);    
    }    
    
    @Override    
    public String toString() {        
        return "StateOne{}";    
    }
}
```

```java
/** 
* One implementation of the StateInterface 
*/
public class StateTwo implements StateInterface {   
    
    @Override    
    public void doAction(ContextClass contextClass) { 
      	contextClass.setState(this);        
        System.out.println("The state now is 2 in the context: " + contextClass);    
    }    
    
    @Override    
    public String toString() {        
        return "StateTwo{}";    
    }
}
```

Depois disso, você so precisa utilizar:

```java
public static void main(String[] args){    
    System.out.println("Starts demonstration of the design patterns implementation and functions.\nYou can debug the code if you want to see line by line.");    
    
    ContextClass contextClass = new ContextClass();    
    StateOne stateOne = new StateOne();    
    stateOne.doAction(contextClass);    
    
    System.out.println(contextClass.getState().toString());    
    
    StateTwo stateTwo = new StateTwo();    
    stateTwo.doAction(contextClass);    
    
    System.out.println(contextClass.getState().toString());

}
```

A saída do programa acima é:

`Starts demonstration of the design patterns implementation and functions.
You can debug the code if you want to see line by line.
State of the context vc.com.justa.state.context.ContextClass@60e53b93 changed to: StateOne{}
The state now is 1 in the context: vc.com.justa.state.context.ContextClass@60e53b93
StateOne{}
State of the context vc.com.justa.state.context.ContextClass@60e53b93 changed to: StateTwo{}
The state now is 2 in the context: vc.com.justa.state.context.ContextClass@60e53b93
StateTwo{}`

## Referências

- [Refactoring Guru](https://refactoring.guru/design-patterns)
- [Source Making](https://sourcemaking.com/design_patterns)
- [TutorialsPoint](https://www.tutorialspoint.com/design_pattern)
- [DevMedia](https://www.devmedia.com.br/design-patterns-solucoes-para-problemas-em-projetos-orientado-a-objetos/31266)
- Many other sites that I don't remember right now

