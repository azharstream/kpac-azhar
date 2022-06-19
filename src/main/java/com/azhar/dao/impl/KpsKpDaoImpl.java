package com.azhar.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.azhar.constant.KpsKpConstant;
import com.azhar.dao.KpsKpDao;
import com.azhar.model.KpsKp;

@Repository
public class KpsKpDaoImpl implements KpsKpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<KpsKp> findByKpacSetId(int id) {
		return jdbcTemplate.query(KpsKpConstant.SELECT_KPS_KP_QUERY, new PreparedStatementSetter() {
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1, id);
			}
		}, new RowMapper<KpsKp>() {
			public KpsKp mapRow(ResultSet resultSet, int row) throws SQLException {
				KpsKp kpsKp = new KpsKp();
				kpsKp.setKpacSetId(resultSet.getInt(KpsKpConstant.KPAC_SET_ID));
				kpsKp.setKpacId(resultSet.getInt(KpsKpConstant.KPAC_ID));
				return kpsKp;
			}
		});
	}
}
