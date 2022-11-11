package engtelecom.poo;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Criando um rack...");
        Rack r = new Rack();

        System.out.println("Adicionando máquina real \"M1\" ao rack");
        r.adiciona("M1", 32768, 1024);

        System.out.println("Criando máquina virtual \"MV1\" na máquina real \"M1\"");
        r.obtem("M1").criaMV("MV1", 3000, 200);

        System.out.println("Ligando máquina virtual \"MV1\" que está na máquina real \"M1\"");
        System.out.println("Máquina " + r.obtem("M1").liga("MV1"));

        System.out.println("Desligando máquina virtual \"MV1\" que está na máquina real \"M1\"");
        System.out.println("Máquina " + r.obtem("M1").desliga("MV1"));

        System.out.println("Adicionando as máquinas virtuais \"MV2\", \"MV3\", \"MV4\" e \"MV5\" na máquina real \"M1\"");
        r.obtem("M1").criaMV("MV2", 3000, 100);
        r.obtem("M1").criaMV("MV3", 1000, 300);
        r.obtem("M1").criaMV("MV4", 2000, 50);
        r.obtem("M1").criaMV("MV5", 2000, 300);

        System.out.println("Ligando todas as máquinas virtuais em \"M1\"");
        System.out.println("Máquina " + r.obtem("M1").liga("MV1"));
        System.out.println("Máquina " + r.obtem("M1").liga("MV2"));
        System.out.println("Máquina " + r.obtem("M1").liga("MV3"));
        System.out.println("Máquina " + r.obtem("M1").liga("MV4"));
        System.out.println("Máquina " + r.obtem("M1").liga("MV5"));

        System.out.println("Desligando todas as máquinas virtuais em \"M1\"");
        System.out.println("Máquina " + r.obtem("M1").desliga("MV1"));
        System.out.println("Máquina " + r.obtem("M1").desliga("MV2"));
        System.out.println("Máquina " + r.obtem("M1").desliga("MV3"));
        System.out.println("Máquina " + r.obtem("M1").desliga("MV4"));
        System.out.println("Máquina " + r.obtem("M1").desliga("MV5"));



        System.out.println("Adicionando máquina real \"M2\" ao rack");
        r.adiciona("M2", 32768, 1024);

        System.out.println("Criando máquina virtual \"M2MV1\" na máquina real \"M2\"");
        r.obtem("M2").criaMV("M2MV1", 3000, 200);

        System.out.println("Ligando máquina virtual \"M2MV1\" que está na máquina real \"M2\"");
        System.out.println("Máquina " + r.obtem("M2").liga("M2MV1"));

        System.out.println("Desligando máquina virtual \"MV1\" que está na máquina real \"M2\"");
        System.out.println("Máquina " + r.obtem("M2").desliga("M2MV1"));

        System.out.println("Adicionando as máquinas virtuais \"M2MV2\", \"M2MV3\", \"M2MV4\" e \"M2MV5\" na máquina real \"M2\"");
        r.obtem("M2").criaMV("M2MV2", 3000, 100);
        r.obtem("M2").criaMV("M2MV3", 1000, 300);
        r.obtem("M2").criaMV("M2MV4", 2000, 50);
        r.obtem("M2").criaMV("M2MV5", 2000, 300);

        System.out.println("Ligando todas as máquinas virtuais em \"M2\"");
        System.out.println("Máquina " + r.obtem("M2").liga("M2MV1"));
        System.out.println("Máquina " + r.obtem("M2").liga("M2MV2"));
        System.out.println("Máquina " + r.obtem("M2").liga("M2MV3"));
        System.out.println("Máquina " + r.obtem("M2").liga("M2MV4"));
        System.out.println("Máquina " + r.obtem("M2").liga("M2MV5"));

        System.out.println("Desligando todas as máquinas virtuais em \"M2\"");
        System.out.println("Máquina " + r.obtem("M2").desliga("M2MV1"));
        System.out.println("Máquina " + r.obtem("M2").desliga("M2MV2"));
        System.out.println("Máquina " + r.obtem("M2").desliga("M2MV3"));
        System.out.println("Máquina " + r.obtem("M2").desliga("M2MV4"));
        System.out.println("Máquina " + r.obtem("M2").desliga("M2MV5"));
    }
}
