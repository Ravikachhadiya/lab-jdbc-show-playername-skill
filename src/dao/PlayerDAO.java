package dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO{
	public List<Player> getAllPlayers() throws ClassNotFoundException, SQLException, IOException{
		List<Player> playerList = new ArrayList<Player>();
		
		ConnectionManager connectionManager = new ConnectionManager();
		Statement st = connectionManager.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM PLAYER");
		
		while(rs.next()) {
			
			
			long playerId = rs.getLong("id");
			String name = rs.getString("name");
			String country = rs.getString("country");
			
			SkillDAO skillDAO = new SkillDAO();
			
			Skill skill = skillDAO.listAllSkills(rs.getInt("id"));
			
			Player player = new Player(playerId, name, country, skill);
			
			playerList.add(player);
			connectionManager.getConnection().close();
			
			}
			
		
		return playerList;
	}
}
