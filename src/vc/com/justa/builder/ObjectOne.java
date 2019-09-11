package vc.com.justa.builder;

public class ObjectOne {

    private String attributeOne;
    private String attributeTwo;

    public ObjectOne(String attributeOne, String attributeTwo){
        this.attributeOne = attributeOne;
        this.attributeTwo = attributeTwo;
    }


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
}
