public class Aluno {
    private String name;
    private int age;
    private char gender;
    private boolean classMonitor;
    private String house;

    public void status(){
        System.out.println("Nome: " + this.name);
        System.out.println("Idade: " + this.age);
        System.out.println("Genero: " + this.gender);
        System.out.println("Casa: " + this.house);
        if(this.classMonitor){
            System.out.println(this.name + "é um monitor da classe.");
        }
    }

    public Aluno(String name, int age, char gender, String house){
        this.name = name;
        this.age = age;
        this.house = house;
        this.gender = gender;

        this.classMonitor = false;
        this.status();
    }

    public void setGender(char gender){
        if(gender != 'm' || gender != 'f'){
            System.out.println("Error, gender needs to be 'm' of 'f'");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public boolean isClassMonitor() {
        return classMonitor;
    }

    public void setClassMonitor() {
        if(this.classMonitor){
            this.classMonitor = false;
        } else {
            this.classMonitor = true;
        }
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
