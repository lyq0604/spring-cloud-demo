package ${packageName}.${moduleName}.domain;

import com.blade.system.common.utils.GenIdUtil;
import tk.mybatis.mapper.annotation.KeySql;
import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;

@Table(name = "${tableInfo.tableName}")
@Data
public class ${tableInfo.className} implements Serializable {

    <#list tableInfo.columnList as column>
        /**
        * ${column.columnComment}
        */
        <#if column.primaryKey>
        @Id
        @KeySql(genId = GenIdUtil.class)
        </#if>
        @Column(name = "${column.columnName}")
        private ${column.attrType} ${column.attrName};

    </#list>
}