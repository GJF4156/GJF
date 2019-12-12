package com.lin.lostandfound.test;

import java.io.IOException;

import com.lin.lostandfound.utils.MysqlDumpUtils;
import com.lin.lostandfound.utils.MysqlDumpUtils.BackupInfo;

public class MySqlBackupTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		String username = "root";
		String password = "root";
		String databaseName = "lostandfound";
		String ip = "112.74.191.147";
		String port = "3306";
		MysqlDumpUtils.config(username, password, databaseName, ip, port);
		try {
			BackupInfo back = MysqlDumpUtils.backup("C:\\");
			System.out.println(back.isComplete() + " " + back.getErrMsg() + " "
					+ back.getPath() + " " + back.getSize() + " "
					+ back.getClass());
			String tableSql = MysqlDumpUtils.getTableSql("user");
			System.out.println(tableSql);
			System.out.println(MysqlDumpUtils.getBackupPath().getPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
