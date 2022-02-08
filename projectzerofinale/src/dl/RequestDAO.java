package dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Reimbursement;

public class RequestDAO implements DAO<Reimbursement, Integer>{
	
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Override
	public Reimbursement findById(Integer id) {
		// TODO Auto-generated method stub
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from reimbursements where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Reimbursement(rs.getString("type"), rs.getString("description"),rs.getInt("amount"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Cannot connect with the database");
		}
		
		return null;
	}

	@Override
	public List<Reimbursement> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from reimbursements";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getString("type"), rs.getString("description"), rs.getInt("id")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public void add(Reimbursement newObject) {
		// TODO Auto-generated method stub
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "insert into reimbursements (type, description, amount) values (?,?,?);";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, newObject.getType());
			pstmt.setString(2, newObject.getDescription());
			pstmt.setInt(3, newObject.getAmount());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Reimbursement newObject) {
		// TODO Auto-generated method stub
		
	}
	

}
