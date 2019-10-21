package com.blade.system.tools.service;

import com.blade.common.utils.StringUtils;
import com.blade.system.common.utils.GeneratorUtil;
import com.blade.system.common.vo.TableVO;
import com.blade.system.tools.domain.Generator;
import com.blade.system.tools.domain.ColumnInfo;
import com.blade.system.tools.domain.TableInfo;
import com.blade.system.tools.mapper.GeneratorMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class GeneratorService {

    @Autowired
    private GeneratorMapper generatorMapper;
    @Autowired
    private Configuration freeMarkConfig;

    public List<String> selectDatabaseList() {
        return generatorMapper.selectDatabaseInfo();
    }

    public List<TableVO> selectTableList(String database,String tableName){
        return generatorMapper.selectTableList(database,tableName);
    }

    public byte[] generate(Generator generator) {
        buildInfo(generator);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        Template template = null;
        try {
            // 实体类文件
            template = freeMarkConfig.getTemplate(GeneratorUtil.ENTITY_TEMPLATE_LOCATION);
            String entity = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator,"entity")));
            IOUtils.write(entity, zipOutputStream, "utf-8");
            // mapper接口文件
            template = freeMarkConfig.getTemplate(GeneratorUtil.MAPPER_TEMPLATE_LOCATION);
            String mapper = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator,"mapper")));
            IOUtils.write(mapper, zipOutputStream, "utf-8");
            // mapper.xml文件
            template = freeMarkConfig.getTemplate(GeneratorUtil.MAPPERXML_TEMPLATE_LOCATION);
            String mapperXml = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator,"mapperXml")));
            IOUtils.write(mapperXml, zipOutputStream, "utf-8");
            // service文件
            template = freeMarkConfig.getTemplate(GeneratorUtil.SERVICE_TEMPLATE_LOCATION);
            String service = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator,"service")));
            IOUtils.write(service, zipOutputStream, "utf-8");
            // controller文件
            template = freeMarkConfig.getTemplate(GeneratorUtil.CONTROLLER_TEMPLATE_LOCATION);
            String controller = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator,"controller")));
            IOUtils.write(controller, zipOutputStream, "utf-8");
            // vue index文件
            template = freeMarkConfig.getTemplate(GeneratorUtil.VUEINDEX_TEMPLATE_LOCATION);
            String vue_index = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getVueFullPath(generator,"VUE_INDEX")));
            IOUtils.write(vue_index, zipOutputStream, "utf-8");
            // vue form文件
            template = freeMarkConfig.getTemplate(GeneratorUtil.VUEFORM_TEMPLATE_LOCATION);
            String vue_form = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getVueFullPath(generator,"VUE_FORM")));
            IOUtils.write(vue_form, zipOutputStream, "utf-8");
            // vue js文件
            template = freeMarkConfig.getTemplate(GeneratorUtil.VUEJS_TEMPLATE_LOCATION);
            String vue_js = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getVueFullPath(generator,"VUE_JS")));
            IOUtils.write(vue_js, zipOutputStream, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }finally {
            try {
                zipOutputStream.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputStream.toByteArray();
    }

    /**
     * 构建信息
     * @param generator
     */
    private void buildInfo(Generator generator) {
        generator.setDate(LocalDateTime.now());
        //构建TableInfo信息
        buildTableInfo(generator.getTableInfo());
    }

    /**
     * 构建表信息
     * @param tableInfo
     */
    private void buildTableInfo(TableInfo tableInfo) {
        String className = generateClassName(tableInfo.getTableName());
        tableInfo.setClassName(className);
        tableInfo.setClassNameLower(className.toLowerCase());
        buildColumnInfo(tableInfo.getColumnList());
    }

    /**
     * 构建列信息
     * @param columnList
     */
    private void buildColumnInfo(List<ColumnInfo> columnList) {
        columnList.forEach(column -> {
            column.setAttrName(generateAttrName(column.getColumnName()));
            column.setAttrType(GeneratorUtil.TYPE_MAPPING.get(column.getColumnType()));
        });
    }

    /**
     * 根据字段名生成属性名称
     * @param columnName
     * @return
     */
    private String generateAttrName(String columnName) {
        String attrName = StringUtils.convertToCamelCase(columnName);
        if(Character.isLowerCase(attrName.charAt(0))) {
            return attrName;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(attrName.charAt(0))).append(attrName.substring(1)).toString();
        }
    }

    /**
     * 根据表名生成类名
     * @param tableName
     * @return
     */
    private String generateClassName(String tableName) {
        // 去除前缀
        tableName = tableName.substring(tableName.indexOf('_')+1);
        return StringUtils.convertToCamelCase(tableName);
    }

    public List<ColumnInfo> selectColumnList(String database, String tableName) {
        return generatorMapper.selectColumnList(database,tableName);
    }
}
