package com.dusty.teamroster.models;

import java.util.ArrayList;

public class Team {
	private String team_name;
	public String getTeam_name() {
		return team_name;
	}
	private static ArrayList<Team> teams = new ArrayList<Team>();
	
	private ArrayList<Player> players = new ArrayList<>(); 
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public Team() {
		
	}
	public Team(String team_name) {
		this.team_name = team_name;
		
	}
	
	public static void addTeam(String team_name) {
		Team newTeam = new Team(team_name);
		Team.teams.add(newTeam);
	}
	public void removeTeam(int index) {
		Team.teams.remove(index);
	}
	public void addPlayer(String first_name, String last_name, Integer age) {
		Player newPlayer = new Player(first_name, last_name, age);
		this.players.add(newPlayer);
		
	}
	public static ArrayList<Team> getTeams(){
		return Team.teams;
	}
	
	
}
