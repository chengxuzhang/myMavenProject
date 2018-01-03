package com.qing.core.bean;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.UUID;
import com.qing.core.utils.StringUtils;

/**
 * @description 数据库表字段模型
 * 
 * @author 谢进伟
 * 
 * @createDate 2016-1-31 下午9:54:43
 */
public class TableColumnBean {
	
	/** 是否自增 **/
	private Boolean isAutoIncrement;
	/** 是否大小写敏感的 **/
	private Boolean isCaseSensitive;
	/** 是否是可以用在where子句指定的列 **/
	private Boolean isSearchable;
	/** 是否可以为null **/
	private Boolean isNullable;
	/** 是否可以签署数字 **/
	private Boolean isSigned;
	/** 正常字符的最大长度 **/
	private int columnDisplaySize;
	/** 列名 **/
	private String columnName;
	/**
	 * 获取指定列的指定列的大小。对于数值型数据,这是最大的精度。对于字符数据,这是长度的字符。datetime数据类型,这是长度的字符的字符串表示(
	 * 假设的最大允许精确分数秒组件)。对于二进制数据,这是长度的字节。对于ROWID数据类型,这是长度的字节。0返回数据类型的列的大小,不适用。
	 **/
	private int precision;
	/** 小数点右边的有效数字字符数 **/
	private int scale;
	/** 表名 **/
	private String tableName;
	/** 获取指定列的表的目录名称(通常会是数据库名称) **/
	private String catalogName;
	/** 列的SQL类型。java.sql.Types枚举值 **/
	private int columnType;
	/** 列的数据库的类型名称 **/
	private String columnTypeName;
	/** 列是否只读不可写 **/
	private Boolean isReadOnly;
	/** 列是否可写 **/
	private Boolean isWritable;
	/** 列对应的java数据类型 **/
	private String columnClassName;
	/** 是否是主键 **/
	private Boolean isPrimaryKey;
	/** 是否是外键 **/
	private Boolean isForeignKey;
	/** 外键名称 **/
	private String foreignKeyName;
	/** 引用的主表名称 **/
	private String referenceTable;
	/** 引用的主表列 **/
	private String referenceColumn;
	/** 驼峰石命名值(pojo 属性值) **/
	private String columnJavaFieldName;
	/** javaBean 标准getter/setter后缀 **/
	private String columnJavaGetterOrSetterSuffix;
	/** java数据类型 **/
	private String columnJavaType;
	/** 列备注 **/
	private String remarks;
	/** 是否为创建时间 **/
	private Boolean isCreateTime;
	/** 是否为修改时间 **/
	private Boolean isModifiedTime;
	/** 新增时是否可编辑 **/
	private Boolean isAddCanEdit;
	/** 修改时是否可编辑 **/
	private Boolean isUpdateCanEdit;
	/** 数据源方案名 **/
	private String datasourceCatalog;
	/** 数据源名称 **/
	private String datasourceName;
	/** 数据源表名 **/
	private String datasourceTableName;
	/** 数据源表 key 列 **/
	private String datasourceKeyColumn;
	/** 数据源表 value 列 **/
	private String datasourceValueColumn;
	/** 数据源Sql **/
	private String datasourceSql;
	/** 引用表显示列 **/
	private List<TableColumnBean> referenceTableShowColumns;
	/** 引用表可作检索条件列 **/
	private List<TableColumnBean> referenceTableSearchColumns;
	
	/** 属性json串 **/
	private String attrsJsonStr;
	
	private boolean isSetPrecision;
	private boolean isSetScale;
	private boolean isSetColumnType;
	private boolean isSetJavaType;
	
	public Boolean getIsAutoIncrement() {
		return isAutoIncrement;
	}
	
	public void setIsAutoIncrement(Boolean isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}
	
	public Boolean getIsCaseSensitive() {
		return isCaseSensitive;
	}
	
	public void setIsCaseSensitive(Boolean isCaseSensitive) {
		this.isCaseSensitive = isCaseSensitive;
	}
	
	public Boolean getIsSearchable() {
		return isSearchable;
	}
	
	public void setIsSearchable(Boolean isSearchable) {
		this.isSearchable = isSearchable;
	}
	
	public Boolean getIsNullable() {
		return isNullable;
	}
	
	public void setIsNullable(Boolean isNullable) {
		this.isNullable = isNullable;
	}
	
	public Boolean getIsSigned() {
		return isSigned;
	}
	
	public void setIsSigned(Boolean isSigned) {
		this.isSigned = isSigned;
	}
	
	public int getColumnDisplaySize() {
		return columnDisplaySize;
	}
	
	public void setColumnDisplaySize(int columnDisplaySize) {
		this.columnDisplaySize = columnDisplaySize;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public void setIsPrimaryKey(Boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
	
	public void setIsForeignKey(Boolean isForeignKey) {
		this.isForeignKey = isForeignKey;
	}
	
	/**
	 * @param columnName
	 *            the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
		if(StringUtils.isNotBlank(this.columnName)) {
			this.setColumnJavaFieldName(StringUtils.converToJavaField(this.columnName));
		} else {
			this.setColumnJavaFieldName(StringUtils.converToJavaField(UUID.randomUUID().toString().replace("-" , "")));
		}
	}
	
	/**
	 * @return the precision
	 */
	public int getPrecision() {
		return precision;
	}
	
	/**
	 * @param precision
	 *            the precision to set
	 */
	public void setPrecision(int precision) {
		this.precision = precision;
		this.isSetPrecision = true;
		if(this.isSetColumnType && this.isSetScale) {
			if(!this.isSetJavaType) {
				this.setColumnJavaType(this.convertToJavaDataType());
			}
		}
	}
	
	/**
	 * @return the scale
	 */
	public int getScale() {
		return scale;
	}
	
	/**
	 * @param scale
	 *            the scale to set
	 */
	public void setScale(int scale) {
		this.scale = scale;
		this.isSetScale = true;
		if(this.isSetColumnType && this.isSetPrecision) {
			if(!this.isSetJavaType) {
				this.setColumnJavaType(this.convertToJavaDataType());
			}
		}
	}
	
	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}
	
	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	/**
	 * @return the catalogName
	 */
	public String getCatalogName() {
		return catalogName;
	}
	
	/**
	 * @param catalogName
	 *            the catalogName to set
	 */
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	
	/**
	 * @return the columnType
	 */
	public int getColumnType() {
		return columnType;
	}
	
	/**
	 * @param columnType
	 *            the columnType to set
	 */
	public void setColumnType(int columnType) {
		this.columnType = columnType;
		this.isSetColumnType = true;
		if(this.isSetPrecision && this.isSetScale) {
			if(!this.isSetJavaType) {
				this.setColumnJavaType(this.convertToJavaDataType());
			}
		}
	}
	
	/**
	 * @return the columnTypeName
	 */
	public String getColumnTypeName() {
		return columnTypeName;
	}
	
	/**
	 * @param columnTypeName
	 *            the columnTypeName to set
	 */
	public void setColumnTypeName(String columnTypeName) {
		this.columnTypeName = columnTypeName;
	}
	
	/**
	 * @return the isReadOnly
	 */
	public Boolean getIsReadOnly() {
		return isReadOnly;
	}
	
	/**
	 * @param isReadOnly
	 *            the isReadOnly to set
	 */
	public void setIsReadOnly(Boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}
	
	/**
	 * @return the isWritable
	 */
	public Boolean getIsWritable() {
		return isWritable;
	}
	
	/**
	 * @param isWritable
	 *            the isWritable to set
	 */
	public void setIsWritable(Boolean isWritable) {
		this.isWritable = isWritable;
	}
	
	/**
	 * @return the columnClassName
	 */
	public String getColumnClassName() {
		return columnClassName;
	}
	
	/**
	 * @param columnClassName
	 *            the columnClassName to set
	 */
	public void setColumnClassName(String columnClassName) {
		this.columnClassName = columnClassName;
	}
	
	/**
	 * @return the isPrimaryKey
	 */
	public Boolean getIsPrimaryKey() {
		return isPrimaryKey;
	}
	
	/**
	 * @param isPrimaryKey
	 *            the isPrimaryKey to set
	 */
	public void setPrimaryKey(Boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
	
	/**
	 * @return the isForeignKey
	 */
	public Boolean getIsForeignKey() {
		return isForeignKey;
	}
	
	/**
	 * @param isForeignKey
	 *            the isForeignKey to set
	 */
	public void setForeignKey(Boolean isForeignKey) {
		this.isForeignKey = isForeignKey;
	}
	
	public String getForeignKeyName() {
		return foreignKeyName;
	}
	
	public void setForeignKeyName(String foreignKeyName) {
		this.foreignKeyName = foreignKeyName;
	}
	
	/**
	 * @return the referenceTable
	 */
	public String getReferenceTable() {
		return referenceTable;
	}
	
	/**
	 * @param referenceTable
	 *            the referenceTable to set
	 */
	public void setReferenceTable(String referenceTable) {
		this.referenceTable = referenceTable;
	}
	
	/**
	 * @return the referenceColumn
	 */
	public String getReferenceColumn() {
		return referenceColumn;
	}
	
	/**
	 * @param referenceColumn
	 *            the referenceColumn to set
	 */
	public void setReferenceColumn(String referenceColumn) {
		this.referenceColumn = referenceColumn;
	}
	
	/**
	 * @return the columnJavaFieldName
	 */
	public String getColumnJavaFieldName() {
		return this.columnJavaFieldName;
	}
	
	public String getColumnJavaGetterOrSetterSuffix() {
		if(StringUtils.isNotBlank(this.columnJavaFieldName)) {
			this.columnJavaGetterOrSetterSuffix = StringUtils.getGetterOrSetterSuffix(this.columnJavaFieldName);
		}
		return columnJavaGetterOrSetterSuffix;
	}
	
	/**
	 * @param columnJavaFieldName
	 *            the columnJavaFieldName to set
	 */
	public void setColumnJavaFieldName(String columnJavaFieldName) {
		this.columnJavaFieldName = columnJavaFieldName;
	}
	
	/**
	 * @return the columnJavaType
	 */
	public String getColumnJavaType() {
		return columnJavaType;
	}
	
	/**
	 * @param columnJavaType
	 *            the columnJavaType to set
	 */
	public void setColumnJavaType(String columnJavaType) {
		this.columnJavaType = columnJavaType;
		this.isSetJavaType = true;
	}
	
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * @param remarks
	 *            the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Boolean getIsCreateTime() {
		return isCreateTime;
	}
	
	public void setIsCreateTime(Boolean isCreateTime) {
		this.isCreateTime = isCreateTime;
	}
	
	public Boolean getIsModifiedTime() {
		return isModifiedTime;
	}
	
	public void setIsModifiedTime(Boolean isModifiedTime) {
		this.isModifiedTime = isModifiedTime;
	}
	
	public Boolean getIsAddCanEdit() {
		return isAddCanEdit;
	}
	
	public void setIsAddCanEdit(Boolean isAddCanEdit) {
		this.isAddCanEdit = isAddCanEdit;
	}
	
	public Boolean getIsUpdateCanEdit() {
		return isUpdateCanEdit;
	}
	
	public void setIsUpdateCanEdit(Boolean isUpdateCanEdit) {
		this.isUpdateCanEdit = isUpdateCanEdit;
	}
	
	public String getAttrsJsonStr() {
		return attrsJsonStr;
	}
	
	public void setAttrsJsonStr(String attrsJsonStr) {
		this.attrsJsonStr = attrsJsonStr;
	}
	
	public String getDatasourceName() {
		return datasourceName;
	}
	
	public void setDatasourceName(String datasourceName) {
		this.datasourceName = datasourceName;
	}
	
	public String getDatasourceCatalog() {
		return datasourceCatalog;
	}
	
	public void setDatasourceCatalog(String datasourceCatalog) {
		this.datasourceCatalog = datasourceCatalog;
	}
	
	public String getDatasourceTableName() {
		return datasourceTableName;
	}
	
	public void setDatasourceTableName(String datasourceTableName) {
		this.datasourceTableName = datasourceTableName;
	}
	
	public String getDatasourceKeyColumn() {
		return datasourceKeyColumn;
	}
	
	public void setDatasourceKeyColumn(String datasourceKeyColumn) {
		this.datasourceKeyColumn = datasourceKeyColumn;
	}
	
	public String getDatasourceValueColumn() {
		return datasourceValueColumn;
	}
	
	public void setDatasourceValueColumn(String datasourceValueColumn) {
		this.datasourceValueColumn = datasourceValueColumn;
	}
	
	public String getDatasourceSql() {
		return datasourceSql;
	}
	
	public void setDatasourceSql(String datasourceSql) {
		this.datasourceSql = datasourceSql;
	}
	
	/**
	 * 根据java.sql.Types来转换成对应的java类型
	 * 
	 * @return
	 * @throws SQLException
	 */
	private String convertToJavaDataType() {
		String className = String.class.getName();
		int sqlType = this.getColumnType();
		switch(sqlType){
			case Types.BIT:
				if(this.getPrecision() == 1) {
					className = java.lang.Boolean.class.getName();
				} else if(this.getPrecision() > 1 && this.getPrecision() <= 8) {
					className = java.lang.Byte.class.getName();
				} else if(this.getPrecision() > 8 && this.getPrecision() <= 16) {
					className = java.lang.Short.class.getName();
				} else if(this.getPrecision() > 16 && this.getPrecision() <= 32) {
					className = java.lang.Integer.class.getName();
				} else if(this.getPrecision() > 32 && this.getPrecision() <= 64) {
					className = java.lang.Long.class.getName();
				}
				break;
			case Types.NUMERIC:
			case Types.DECIMAL:
				if(this.getScale() == 0) {
					if(this.getPrecision() == 1) {
						className = java.lang.Boolean.class.getName();
					} else if(this.getPrecision() > 1 && this.getPrecision() <= 4) {
						className = java.lang.Short.class.getName();
					} else if(this.getPrecision() > 4 && this.getPrecision() <= 9) {
						className = java.lang.Integer.class.getName();
					} else if(this.getPrecision() > 9 && this.getPrecision() <= 18) {
						className = java.lang.Long.class.getName();
					} else if(this.getPrecision() > 18 && this.getPrecision() <= 38) {
						className = java.math.BigInteger.class.getName();
					}
				} else {
					className = java.lang.Double.class.getName();
				}
				break;
			case Types.TINYINT:
				className = java.lang.Byte.class.getName();
				break;
			case Types.SMALLINT:
				className = java.lang.Short.class.getName();
				break;
			case Types.INTEGER:
				className = java.lang.Integer.class.getName();
				break;
			case Types.BIGINT:
				className = java.lang.Long.class.getName();
				break;
			case Types.REAL:
			case Types.FLOAT:
				className = java.lang.Float.class.getName();
				break;
			case Types.DOUBLE:
				className = java.lang.Double.class.getName();
				break;
			case Types.DATE:
				className = java.util.Date.class.getName();
				break;
			case Types.TIME:
				className = java.sql.Time.class.getName();
				break;
			case Types.TIMESTAMP:
				className = java.sql.Timestamp.class.getName();
				break;
			case Types.STRUCT:
				className = java.sql.Struct.class.getName();
				break;
			case Types.ARRAY:
				className = java.sql.Array.class.getName();
				break;
			case Types.SQLXML:
				className = java.sql.SQLXML.class.getName();
				break;
			case Types.REF:
				className = java.sql.Ref.class.getName();
				break;
			case Types.BOOLEAN:
				className = java.lang.Boolean.class.getName();
				break;
			case Types.BLOB:
			case Types.CLOB:
			case Types.NCLOB:
			case Types.BINARY:
			case Types.VARBINARY:
			case Types.LONGVARBINARY:
				className = "byte[]";
				break;
			case Types.NULL:
			case Types.OTHER:
			case Types.JAVA_OBJECT:
			case Types.DISTINCT:
			case Types.CHAR:
			case Types.VARCHAR:
			case Types.LONGVARCHAR:
			case Types.DATALINK:
			case Types.ROWID:
			case Types.NCHAR:
			case Types.NVARCHAR:
			case Types.LONGNVARCHAR:
			case Types.REF_CURSOR:
			case Types.TIME_WITH_TIMEZONE:
			case Types.TIMESTAMP_WITH_TIMEZONE:
				className = java.lang.String.class.getName();
				break;
			default:
				className = java.lang.String.class.getName();
		}
		return className;
	}
	
	public List<TableColumnBean> getReferenceTableShowColumns() {
		return referenceTableShowColumns;
	}
	
	public void setReferenceTableShowColumns(List<TableColumnBean> referenceTableShowColumns) {
		this.referenceTableShowColumns = referenceTableShowColumns;
	}
	
	public List<TableColumnBean> getReferenceTableSearchColumns() {
		return referenceTableSearchColumns;
	}
	
	public void setReferenceTableSearchColumns(List<TableColumnBean> referenceTableSearchColumns) {
		this.referenceTableSearchColumns = referenceTableSearchColumns;
	}
}
