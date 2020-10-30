package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


import dao.PlayerDAO;
import model.Player;
import model.Skill;

public class Main{
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
		PlayerDAO playerDAO = new PlayerDAO();
		
		List<Player> playerList = new ArrayList<Player>();
		
		playerList = playerDAO.getAllPlayers();
		
		Iterator<Player> iterator = playerList.iterator();
		
		System.out.println("List of all player and their skill\n");
		System.out.printf("%-5s %-10s %-10s %s\n", "Id", "Name", "Country", "Skill");
		while(iterator.hasNext()) {
			Player player = iterator.next();
			Skill skill = player.getSkill();
			
			System.out.printf("%-5s %-10s %-10s %s\n", player.getPlayerId(), player.getName(), player.getCountry(), skill.getSkillName());
		}
	}
}
