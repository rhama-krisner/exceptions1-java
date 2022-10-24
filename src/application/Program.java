package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Número do quarto: ");
            int numero = sc.nextInt();
            System.out.print("Data de Check-in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Data de Check-Out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reservation);
            System.out.println("=======================");
            System.out.println();

            System.out.println();
            System.out.println("Entre com a data, para atualizar a reserva: ");
            System.out.print("Data de Check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de Check-Out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reserva: " + reservation);
        } catch (ParseException e) {
            System.out.println("Formato de data inválida.");
        } catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado.");
        }

    }
}

