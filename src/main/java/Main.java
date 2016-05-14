import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath*:contacts.properties")

public class Main {
/*
    public static void main(String[] args) {
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactService cs = context.getBean(ContactService.class);
        MappedContact contact = new MappedContact("Maxim", "Rudenko", "01292");
        cs.addContact(contact);
        MappedContact contact2 = new MappedContact("Maximas", "Rudenko", "012ss92");
        cs.addContact(contact2);
     }
*/
}









