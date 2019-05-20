package com.google.code.shardbatis.converter;

import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;

/**
 * @author sean.he
 * 
 */
public class InsertSqlConverter extends AbstractSqlConverter {

	@Override
	protected Statement doConvert(Statement statement, Object params, String mapperId) {

		if (!(statement instanceof Insert)) {
			throw new IllegalArgumentException("The argument statement must is instance of Insert.");
		}

		Insert insert = (Insert) statement;
		String name = insert.getTable().getName();
		insert.getTable().setName(this.convertTableName(name, params, mapperId));

		return insert;
	}
}
