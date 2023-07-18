<template>
  <div>
    <el-switch v-model="draggable" active-text="开启拖拽" inactive-text="关闭拖拽"></el-switch>
    <el-button v-if="draggable" type="primary" @click="batchSave">批量保存</el-button>
    <el-button type="danger" @click="batchDelete">批量删除</el-button>
    <el-tree :data="menus" :props="defaultProps" :expand-on-click-node="false" show-checkbox node-key="catId" :default-expanded-keys="expandedKey" :draggable="draggable" :allow-drop="allowDrop" @node-drop="handleDrop" ref="menuTree">
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>
          <!-- 限制三级菜单 -->
          <el-button v-if="node.level<=2" type="text" size="mini" @click="() => append(data)">
            增加菜单
          </el-button>
          <!-- 修改三级菜单 -->
          <el-button type="text" size="mini" @click="edit(data)">
            编辑菜单
          </el-button>
          <!-- 无法删除还有子节点的菜单 -->
          <el-button v-if="node.childNodes.length==0" type="text" size="mini" @click="() => remove(node, data)">
            删除菜单
          </el-button>
        </span>
      </span>
    </el-tree>

    <!-- 打开表单 -->
    <el-dialog :title="title" :visible.sync="dialogVisible" width="30%" :close-on-click-modal="false">
      <!-- 表单 -->
      <el-form :model="category">
        <!-- 绑定按钮 -->
        <el-form-item label="分类名称">
          <el-input v-model="category.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="图标">
          <el-input v-model="category.icon" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="计量单位">
          <el-input v-model="category.productUnit" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitData">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
// 这里可以导入其他文件（比如：组件，工具 js，第三方插件 js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';

export default {
  // import 引入的组件需要注入到对象中才能使用
  components: {},
  props: {},
  data () {
    // 这里存放数据
    return {
      // maxLevel: 3, // 最大层级,特别注意，这里需要设置成3而不是0
      maxLevel: 0, // 最大层级,特别注意，这里需要设置成3而不是0
      title: '',
      category: {
        name: '',
        parentCid: 0,
        catLevel: 0,
        showStatus: 1,
        sort: 0,
        productUnit: '',
        icon: '',
        catId: null
      }, // 分类对象
      menus: [], // 菜单数据
      dialogType: '', // 操作类型，增加还是修改
      dialogVisible: false, // 打开表单功能
      draggable: true, // 拖拽功能
      expandedKey: [], // 默认展开
      defaultProps: {
        children: 'children',
        label: 'name'
      }
    }
  },
  // 计算属性 类似于 data 概念
  computed: {},
  // 监控 data 中的数据变化
  watch: {},
  // 方法集合
  methods: {
    // 获取菜单信息
    getMenus () {
      this.$http({
        url: this.$http.adornUrl('/product/category/list/tree'),
        method: 'get'
      }).then(({ data }) => {
        console.log(data)
        this.menus = data.page
      }).catch(() => { })
    },
    // 批量删除
    batchDelete () {
      let catIds = []

      this.$confirm(`是否批量删除【${catIds}】菜单?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          this.$http({
            url: this.$http.adornUrl('/product/category/delete'),
            method: 'post',
            data: this.$http.adornData(catIds, false)
          }).then(({ data }) => {
            this.$message({
              message: '菜单批量删除成功',
              type: 'success'
            })
            this.getMenus()
          })
        })
        .catch(() => { })
    },
    // 批量保存
    batchSave () {

    },

    // 增加菜单
    append (data) {
      this.dialogType = 'add'
      this.title = '添加分类'
      this.dialogVisible = true // 这个属性可以控制打开表单

      // 添加category时加上默认值
      this.category.catId = null
      this.category.name = ''
      this.category.parentCid = data.catId // 打开的是父id，设置的是子id
      this.category.catLevel = data.catLevel * 1 + 1 // 打开的是父id，设置的是子id
      this.category.showStatus = 1
      this.category.sort = 0
      this.category.icon = ''
      this.category.productUnit = ''
    },

    // 修改菜单
    edit (data) {
      this.dialogType = 'edit'
      this.title = '修改分类'
      this.dialogVisible = true // 这个属性可以控制打开表单

      // 发送请求获取当前节点的最新数据
      this.$http({
        url: this.$http.adornUrl(`/product/category/info/${data.catId}`),
        method: 'get'
      }).then(({ data }) => {
        // 这里可能会被默认值覆盖，所以对全部数据进行回写
        this.category.catId = data.data.catId
        this.category.name = data.data.name
        this.category.icon = data.data.icon
        this.category.productUnit = data.data.productUnit
        this.category.parentCid = data.data.parentCid
        this.category.catLevel = data.data.catLevel
        this.category.showStatus = data.data.showStatus
        this.category.sort = data.data.sort
      }).catch(() => { })
    },

    // 提交数据
    submitData () {
      if (this.dialogType === 'add') {
        // 新增
        this.addCategory()
      }
      if (this.dialogType === 'edit') {
        // 修改
        this.editCategory()
      }
    },

    // 添加三级分类
    addCategory () {
      this.$http({
        url: this.$http.adornUrl('/product/category/save'),
        method: 'post',
        data: this.$http.adornData(this.category, false)
      }).then(({ data }) => {
        this.$message({
          message: '菜单保存成功',
          type: 'success'
        })
        // 关闭对话框
        this.dialogVisible = false
        // 刷新新的菜单列表
        this.getMenus()
        // 设置需要展开的菜单
        this.expandedKey = [this.category.parentCid]
      }).catch(() => { })
    },

    // 修改三级分类
    editCategory () {
      let { catId, name, icon, productUnit } = this.category

      this.$http({
        url: this.$http.adornUrl('/product/category/update'),
        method: 'post',
        // 注意：关键是这里向后端传送了4个参数用于修改
        data: this.$http.adornData({ catId, name, icon, productUnit }, false)
      }).then(({ data }) => {
        this.$message({
          message: '菜单修改成功',
          type: 'success'
        })
        // 关闭对话框
        this.dialogVisible = false
        // 刷新新的菜单列表
        this.getMenus()
        // 设置需要展开的菜单
        this.expandedKey = [this.category.parentCid]
      }).catch(() => { })
    },

    // 删除菜单
    remove (node, data) {
      // 获取节点的id
      let ids = [data.catId]

      // 删除提示框
      this.$confirm(`是否删除【${data.name}】菜单?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          // 核心代码 start
          this.$http({
            url: this.$http.adornUrl('/product/category/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
            // 核心代码 end
          }).then(({ data }) => {
            this.$message({
              message: '菜单删除成功',
              type: 'success'
            })
          }).then(() => {
            // 刷新新的菜单列表
            this.getMenus()
            // 设置需要展开的菜单
            this.expandedKey = [node.parent.data.catId]
          })
            .catch(() => { })
        })
    },

    // 拖动节点的规则
    // 第一层，因为它下面还有两层，因此只能平移
    // 第二层，因为它下面还有一层，因此可以平移或者移动到上一层
    // 第层层，因为它下面没有了，因此可以平移或者移动到上两层
    allowDrop (draggingNode, dropNode, type) {
      // console.log(draggingNode, dropNode, type)
      // 分析 第一步 被拖动的当前节点以及所在的父节点总层数不能大于3
      this.countNodeLevel(draggingNode) // 拖动的节点
      // 当前正在拖动的节点+父节点所在的深度不大于3即可
      let deep = Math.abs(this.maxLevel - draggingNode.level) + 1
      // 如果我拖动第三层节点，【先拖动】（0-3）+1=4，【后拖动】（3-3）+1=1
      // 如果我拖动第二层节点，（3-2）+1=2
      // 如果我拖动第一层节点，（3-1）+1=3
      console.log('深度：', deep)
      console.log('dropNode', dropNode.parent.level)
      // 分成多种情况
      // 2层有子节点就不能移动到3层
      // 2层没有子节点就可以移动到3层
      // 2层能不能移动全靠他的深度决定
      if (type === 'inner') {
        console.log(
          `this.maxLevel：${this.maxLevel}；draggingNode.data.catLevel：${draggingNode.data.catLevel}；dropNode.level：${dropNode.level}：deep + dropNode.level:${deep + dropNode.level}`
        )
        return deep + dropNode.level <= 3
      } else {
        console.log(
          `this.maxLevel：${this.maxLevel}；draggingNode.data.catLevel：${draggingNode.data.catLevel}；dropNode.level：${dropNode.level}：deep + dropNode.parent.level:${deep + dropNode.parent.level}`
        )
        return deep + dropNode.parent.level <= 3
      }
    },

    // 统计当前被拖动节点的总层数（最外层节点三层，内层节点两层，最内层节点一层）
    // 2和4之间共有多少个数？2,3,4 三个数
    // 第三层和第二层共有多少层数？（深度）3-2+1=2
    // 看不懂，这里除了最底层输出的是0，其它层输出的都是3？
    countNodeLevel (node) {
      // 找到所有子节点最深的总层数
      if (node.childNodes != null && node.childNodes.length > 0) {
        for (let i = 0; i < node.childNodes.length; i++) {
          if (node.childNodes[i].level > this.maxLevel) {
            this.maxLevel = node.childNodes[i].level
          }
          this.countNodeLevel(node.childNodes[i])
        }
      } else {
        // 新增
        this.maxLevel = node.level
      }
    }
  },
  // 生命周期 - 创建完成（可以访问当前 this 实例）
  created () {
    this.getMenus()
  },
  mounted () { }, // 生命周期 - 挂载完成（可以访问 DOM 元素）
  beforeCreate () { }, // 生命周期 - 创建之前
  beforeMount () { }, // 生命周期 - 挂载之前
  beforeUpdate () { }, // 生命周期 - 更新之前
  updated () { }, // 生命周期 - 更新之后
  beforeDestroy () { }, // 生命周期 - 销毁之前
  destroyed () { }, // 生命周期 - 销毁完成
  activated () { } // 如果页面有 keep-alive 缓存功能，这个函数会触发
}
</script>
<style lang='scss' scoped>
//@import url(); 引入公共 css 类
</style>