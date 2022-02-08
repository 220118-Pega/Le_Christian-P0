package dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Status;

public class StatusDAO implements DAO<Status, Integer>{

	@Override
	public Status findById(Integer id) {
		// TODO Auto-generated method stub
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from statuses where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Status(rs.getInt("id"), rs.getString("type"), rs.getInt("reimbursementID"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Iterable<Status> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Status> statuses = new ArrayList<Status>();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from statuses";
			PreparedStatement pstmt = connect.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				statuses.add(new Status(rs.getInt("id"), rs.getString("type"), rs.getInt("reimbursementID")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return statuses;
	}

	@Override
	public void add(Status newObject) {
		// TODO Auto-generated method stub
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "insert into statuses (type, reimbursementID) values (?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, newObject.getType());
			pstmt.setInt(2, newObject.getReimbursementID());
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Status newObject) {
		// TODO Auto-generated method stub
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "update statuses set type = ? where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, newObject.getType());
			pstmt.setInt(2, newObject.getReimbursementID());
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
