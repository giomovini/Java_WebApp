package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	protected Connection connection;
	protected ResultSet rs;
	protected PreparedStatement ps;
	protected String sql;
}
