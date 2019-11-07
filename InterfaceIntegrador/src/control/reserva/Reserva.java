package control.reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reserva {

    private int idReserva;
    private String dataHoraReserva;
    private Equipamento equipamento;
    private String nomeResponsavel;
    private String CpfResp;
    private String situacao;
    private String status;

    public static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {

    }

    public Reserva(Equipamento item, String dataHora, String nomeResponsavel, String cpfResp) {
        this.dataHoraReserva = dataHora;
        this.equipamento = item;
        this.nomeResponsavel = nomeResponsavel;
        this.CpfResp = cpfResp;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    private Date newData;

    public Date getNewData() {
        return newData;
    }

    public void setNewData(Date newData) {
        this.newData = newData;
    }

    public String getCpfResp() {
        return CpfResp;
    }

    public void setCpfResp(String CpfResp) {
        this.CpfResp = CpfResp;
    }

    public static ArrayList<Reserva> getLogReservas() {
        return logReservas;
    }

    public static void setLogReservas(ArrayList<Reserva> logReservas) {
        Reserva.logReservas = logReservas;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getDataHoraReserva() {
        return dataHoraReserva;
    }

    public void setDataHoraReserva(String dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento itemReserva) {
        this.equipamento = itemReserva;
    }

    public static String[] getMes() {
        return mes;
    }

    public static void setMes(String[] mes) {
        Reserva.mes = mes;
    }

    public static String[] getDia28() {
        return dia28;
    }

    public static void setDia28(String[] dia28) {
        Reserva.dia28 = dia28;
    }

    public static String[] getDia29() {
        return dia29;
    }

    public static void setDia29(String[] dia29) {
        Reserva.dia29 = dia29;
    }

    public static String[] getDia30() {
        return dia30;
    }

    public static void setDia30(String[] dia30) {
        Reserva.dia30 = dia30;
    }

    public static String[] getDia31() {
        return dia31;
    }

    public static void setDia31(String[] dia31) {
        Reserva.dia31 = dia31;
    }

    public static String[] getAno() {
        return ano;
    }

    public static void setAno(String[] ano) {
        Reserva.ano = ano;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*public static String[] retornaNomeItem() {

     final int asd = CadastroEquipamento.itens.size();

     String[] nomes = new String[asd];

     for (int i = 0; i < CadastroEquipamento.itens.size(); i++) {

     String b = CadastroEquipamento.itens.get(i).getNome();

     nomes[i] = b;
     }
     return nomes;
     }*/
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public static boolean validarReserva(Reserva res) {

        boolean aceito = true;

        for (int i = 0; i < reservas.size(); i++) {
            if ((res.dataHoraReserva.equals(reservas.get(i).dataHoraReserva)) && (res.equipamento.equals(reservas.get(i).equipamento))) {
                aceito = false;
            }
        }

        return aceito;
    }

    public static String verSituacao(String dataReserva) throws ParseException {

        Date datahj = new Date();

        Date dataRes = formatador.parse(dataReserva);

        dataRes.setHours(23);
        dataRes.setMinutes(59);

        if (datahj.after(dataRes)) {

            return "Atrasado";

        } else {
            return "Em dia";
        }

    }

    public static boolean testarData(String dataRes) throws ParseException {
        boolean resposta = true;
        Date datahj = new Date();

        Date dtRes = formatador.parse(dataRes);

        dtRes.setHours(23);
        dtRes.setMinutes(59);

        if (dtRes.before(datahj)) {
            resposta = false;
        }
        return resposta;
    }

    public static ArrayList<Reserva> reservas = new ArrayList();

    private static ArrayList<Reserva> logReservas = new ArrayList();

    private static String ano[] = {"ano", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040"};

    private static String mes[] = {"mês", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

    private static String dia28[] = {"dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
    private static String dia29[] = {"dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"};
    private static String dia30[] = {"dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    private static String dia31[] = {"dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

}
