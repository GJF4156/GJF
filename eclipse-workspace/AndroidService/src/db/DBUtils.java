package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtils {
	private Connection conn;
	private String url = "jdbc:mysql://localhost:3306/javaee?useSSL=false&serverTimezone=UTC";
	private String user = "root";
	private String password = "gjf.33731";
	private Statement sta;
	private ResultSet rs; // �����ݿ�����


	public void openConnect() {
		try {
			// �������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);// �������ݿ�����
			if (conn != null) {
				System.out.println("���ݿ����ӳɹ�"); // ���ӳɹ�����ʾ��Ϣ
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}


	// ��ò�ѯuser�������ݼ�
	public ResultSet getUser() {
		// ���� statement����
		try {
			sta = conn.createStatement(); // ִ��SQL��ѯ���
			rs = sta.executeQuery("select * from user");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}


	// �ж����ݿ����Ƿ����ĳ���û�����������,ע��͵�¼��ʱ���ж�
	public boolean isExistInDB(String username, String password) {
		boolean isFlag = false; // ���� statement����
		try {
			System.out.println("�ж��û�������");
			sta = conn.createStatement(); // ִ��SQL��ѯ���
			rs = sta.executeQuery("select * from user");// ��ý����
			if (rs != null) {
				while (rs.next()) { // ���������
					if (rs.getString("user_name").equals(username)) {
						if (rs.getString("user_pwd").equals(password)) {
							isFlag = true;
							break;
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			isFlag = false;
		}
		return isFlag;


	}


	// ע�� ���û�����������뵽���ݿ�(id���õ����������ģ���˲���Ҫ����)
	public boolean insertDataToDB(String username, String password) {
		String sql = " insert into user ( user_name , user_pwd ) values ( " + "'" + username + "', " + "'" + password
				+ "' )";
		try {
			sta = conn.createStatement();
			// ִ��SQL��ѯ���
			return sta.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	// �ر����ݿ�����
	public void closeConnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (sta != null) {
				sta.close();
			}
			if (conn != null) {
				conn.close();
			}
			System.out.println("�ر����ݿ����ӳɹ�");
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

public static void main(String[] args){
	DBUtils dbUtils = new DBUtils();
	dbUtils.isExistInDB("aaa", "aaa");
	System.out.println("�ɹ�");
}

}
