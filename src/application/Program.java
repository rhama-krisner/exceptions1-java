package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int numero = sc.nextInt();
        System.out.print("Data de Check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data de Check-Out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: Data de check-out anterior à data de check-in");
        } else {
            Reservation reservation = new Reservation(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reservation);
            System.out.println("=======================");
            System.out.println();

            System.out.print("Atualizar reserva? s/n: ");
            String sn = sc.next();
            sn.toLowerCase();
            if (sn.equals("s")) {
                System.out.println();
                System.out.println("Entre com a data, para atualizar a reserva: ");
                System.out.print("Data de Check-in (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Data de Check-Out (dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());

                Date now = new Date();
                if (checkIn.before(now) || checkOut.after(now)) {
                    System.out.println("Erro na reserva: As datas para reservas devem ser datas futuras");
                } else if (!checkOut.after(checkIn)) {
                    System.out.println("Erro na reserva: Data de check-out anterior à data de check-in");
                } else {
                    reservation.updateDates(checkIn, checkOut);
                    System.out.println("Reserva: " + reservation);
                    System.out.println("=======================");
                    System.out.println("Reserva confirmada");
                }
            } else {
                System.out.println("Reserva confirmada");
            }
        }


    }
}
