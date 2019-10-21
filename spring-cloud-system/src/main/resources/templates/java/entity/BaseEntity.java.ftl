package ${packageName}.entity;

import com.blade.system.common.utils.GenIdUtil;
import tk.mybatis.mapper.annotation.KeySql;
import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;
import java.lang.*;

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
        private ${column.attrType} ${column.attrName};

    </#list>
}