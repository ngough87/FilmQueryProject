package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryEngine {
	DatabaseAccessor db = new DatabaseAccessorObject();
	Scanner input = new Scanner(System.in);

	public void mainMenuOptions() throws SQLException {
		System.out.println("Welcome to the Film Query Application! ");
		System.out.println();
		System.out.println("Film Query Options:");
		System.out.println();
		System.out.println("Please make selection from the below options:");
		System.out.println("1. Search for Film  via Film ID ");
		System.out.println("2. Search for Actor via Film ID");
		System.out.println("3. Search for Film via Keyword");
		System.out.println("4. Quit");
		int selection = input.nextInt();
		switch (selection) {
		default:
			System.out.println("That is not an option. Try again.");

			break;

		case 1:
			getFilmById();

			break;

		case 2:
			getActorByFilmId();

			break;
		case 3:
			getFilmByKeyword();
			break;

		case 4:
			exitProgram();

		}
	}

	public void getFilmById() throws SQLException {
		System.out.println("Find film by ID option: ");
		System.out.println("1. Enter film ID to view information:");
		System.out.println("2. Return to main menu");
		System.out.println();
		int choice = input.nextInt();
		if (choice != 1) {
			mainMenuOptions();
		} else {
			viewFilmDetails();

		}

	}

	public void viewFilmDetails() throws SQLException {
		System.out.println("Enter Film ID: ");
		int filmId = input.nextInt();
		Film film = db.findFilmById(filmId);
		System.out.println();

		if (film == null) {
			System.out.println("Record not found, please try again.");

		}
		System.out.println("\t FILM DETAILS");
		System.out.println(film);
		System.out.println(db.findActorsByFilmId(filmId));
		System.out.println();
		System.out.println("Enter (1) for Main Menu");
		System.out.println("Enter (2) to Quit Program");
		int next = input.nextInt();
		System.out.println();

		if (next == 1) {
			mainMenuOptions();
		} else {
			exitProgram();
		}
	}

	public void getActorByFilmId() throws SQLException {
		System.out.println("Find actor by Film ID option: ");
		System.out.println("1. Enter Film ID to view Actor information");
		System.out.println("2. Return to main menu");
		System.out.println();
		int choice = input.nextInt();
		if (choice != 1) {
			mainMenuOptions();
		} else {
			viewActorDetailsByFilmId();

		}

	}

	public void viewActorDetailsByFilmId() throws SQLException {
		System.out.println("Enter Film ID: ");
		int actorByFilmId = input.nextInt();
		List<Actor> actor = db.findActorsByFilmId(actorByFilmId);
		System.out.println();
		System.out.println("\t ACTOR DETAILS");
		System.out.println(actor);
		System.out.println();
		System.out.println("Enter (1) for Main Menu");
		System.out.println("Enter (2) to Quit Program");
		int next = input.nextInt();
		System.out.println();

		if (next == 1) {
			mainMenuOptions();
		} else {
			exitProgram();
		}
	}

	public void getFilmByKeyword() throws SQLException {
		System.out.println("Find Film By Keyword: ");
		System.out.println("1. Enter Keyword for film details");
		System.out.println("2. Return to main menu");
		System.out.println();
		int choice = input.nextInt();
		if (choice != 1) {
			mainMenuOptions();
		} else {
			viewFilmByKeyword();

		}

	}

	public void viewFilmByKeyword() throws SQLException {

		System.out.println("Enter Keyword: ");
		String filmByKeyword = input.next();
		List<Film> list = db.findFilmByKeyword(filmByKeyword);

		if (list.isEmpty()) {
			System.out.println("Record not found. Try again! ");
			System.out.println();
			mainMenuOptions();
		} else {
			System.out.println();
			System.out.println("\t FILM DETAILS");
			System.out.println(list);

			System.out.println(db.findActorsByFilmKeyword(filmByKeyword));
			System.out.println("Enter (1) for Main Menu");
			System.out.println("Enter (2) to Quit Program");
			int next = input.nextInt();
			System.out.println();

			if (next == 1) {
				mainMenuOptions();

			} else {
				exitProgram();
			}

		}
	}

	private void exitProgram() {
		System.out.println("Goodbye, see you next time!");

	}

}
