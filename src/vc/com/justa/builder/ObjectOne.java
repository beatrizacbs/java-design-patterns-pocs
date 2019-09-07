package vc.com.justa.builder;

public class ObjectOne {

    private String attributeOne;
    private String attributeTwo;

    public ObjectOne(String attributeOne, String attributeTwo){
        this.attributeOne = attributeOne;
        this.attributeTwo = attributeTwo;
    }

    public static class Builder {
        private String attributeOne;
        private String attributeTwo;

        public Builder(){}

        public Builder setAttributeOne(String attributeOne){
            this.attributeOne = attributeOne;
            return this;
        }

        public Builder setAttributeTwo(String attributeTwo){
            this.attributeTwo = attributeTwo;
            return this;
        }

        public ObjectOne build(){
            return new ObjectOne(attributeOne, attributeTwo);
        }
    }
}