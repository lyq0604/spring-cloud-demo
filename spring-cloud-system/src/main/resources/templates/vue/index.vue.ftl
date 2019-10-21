<template>
    <div class="app-container">
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <#list tableInfo.columnList as column>
                    <#if column.enableListQuery>
                        <el-input style="width: 12%" v-model="queryForm.${column.attrName}" clearable size="mini" placeholder="请输入${column.columnComment}"/>
                    </#if>
                </#list>
                <el-button-group>
                    <el-button type="primary" size="mini" icon="el-icon-search" @click="loadTableData">搜索</el-button>
                    <el-button type="success" size="mini" icon="el-icon-plus" @click="handleCreate">新增</el-button>
                </el-button-group>
            </div>
            <div>
                <el-table ref="table" :data="tableData" style="width: 100%">
                    <el-table-column type="index" label="序号" width="100%" align="center"/>
                    <#list tableInfo.columnList as column>
                        <#if column.enableListView>
                            <el-table-column prop="${column.attrName}" label="${column.columnComment}" width="200" align="center"/>
                        </#if>
                    </#list>
                    <el-table-column label="操作" align="center">
                        <template slot-scope="scope">
                            <el-button type="primary" size="small" @click="handleView(scope.row.id)">查看</el-button>
                            <el-button type="success" size="small" @click="handleEdit(scope.row.id)">编辑</el-button>
                            <el-button type="danger" size="small" @click="handleDelete(scope.row.id)">删除</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <div class="block" style="margin-top: 10px">
                    <el-pagination
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :current-page="queryForm.pageNum"
                            :page-sizes="[10,20,50,100]"
                            :page-size="queryForm.pageSize"
                            layout="total, sizes, prev, pager, next, jumper"
                            background
                            :total="total">
                    </el-pagination>
                </div>
            </div>
        </el-card>
        <form-child ref="formChild" @reload="loadTableData" :status="formStatus"/>
    </div>
</template>

<script>
import { getPage, getByKey, update, deleteByKey } from '@/api/${moduleName}/${tableInfo.className}/index'
import FormChild from './components/form'

export default {
    components: {
        FormChild
    },
    data() {
        return {
            tableData: [],
            total: 0,
            queryForm: {
                pageNum: 1,
                pageSize: 10,
                <#list tableInfo.columnList as column>
                    <#if column.enableListQuery>
                        ${column.attrName}: ''<#if column_index != tableInfo.columnList?size-1>,</#if>
                    </#if>
                </#list>
            },
            formStatus: 'view'
        }
    },
    created() {
        this.loadTableData()
    },
    methods: {
        loadTableData() {
            getPage(this.queryForm).then(res => {
                const { data } = res
                this.tableData = data.data
                this.total = data.total
            })
        },
        /**
         * 改变页面数据量
         * @param val
         */
        handleSizeChange(val) {
            this.queryForm.pageSize = val
            this.loadTableData()
        },
        /**
         * 页跳转
         * @param val
         */
        handleCurrentChange(val) {
            this.queryForm.pageNum = val
            this.loadTableData()
        },
        /**
         * 根据主键删除
         */
        handleDelete(id) {
            this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                deleteByKey(id).then(res => {
                    this.$message({
                    message: '删除成功！',
                    type: 'success'
                })
                this.loadTableData()
        })
        }).catch(() => {
                this.$message({
                type: 'info',
                message: '已取消删除'
            })
        })
        },
        /**
         * 查看
         */
        handleView(id) {
            this.$refs.formChild.show(id)
            this.formStatus = 'view'
        },
        /**
         * 编辑
         */
        handleEdit(id) {
            this.$refs.formChild.show(id)
            this.formStatus = 'edit'
        },
        /**
         * 新增
         */
        handleCreate() {
            this.$refs.formChild.show(null)
            this.formStatus = 'create'
        }
    }
}
</script>
