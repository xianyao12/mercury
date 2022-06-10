package com.galaxy.mercury.test;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.galaxy.mercury.utils.other.CommonTool;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 转树
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/5/9 11:16
 */
public class Tree {
    private static final String ID = "id";
    private static final String LABEL = "label";
    private static final String PARENT_ID = "parentId";
    private static final String CHILDREN = "children";

    public static void main(String[] args) {
        String treeStr = "{\"msg\":\"请求成功\",\"code\":0,\"data\":[{\"isIframe\":0,\"query\":null,\"icon\":\"ri-home-4-line\",\"orderNum\":1,\"updateUser\":null,\"menuName\":\"message.router.home\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:55\",\"parentId\":0,\"isShow\":1,\"path\":\"/home\",\"isFixedTag\":1,\"competence\":[\"root\",\"user\"],\"component\":\"system/home\",\"createTime\":\"2022-03-28T11:31:53\",\"isKeepAlive\":1,\"menuId\":1,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"ri-settings-4-line\",\"orderNum\":2,\"updateUser\":null,\"menuName\":\"message.router.system\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:59\",\"parentId\":0,\"isShow\":1,\"path\":\"/system\",\"isFixedTag\":0,\"competence\":[\"root\"],\"component\":\"layout/routerView/parent\",\"createTime\":\"2022-03-28T11:34:05\",\"isKeepAlive\":1,\"menuId\":2,\"menuType\":\"C\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"ri-group-line\",\"orderNum\":1,\"updateUser\":null,\"menuName\":\"message.router.systemUser\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:53\",\"parentId\":2,\"isShow\":1,\"path\":\"/user\",\"isFixedTag\":0,\"competence\":[\"user\"],\"component\":\"system/user\",\"createTime\":\"2022-03-28T11:34:58\",\"isKeepAlive\":1,\"menuId\":3,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"ri-node-tree\",\"orderNum\":4,\"updateUser\":null,\"menuName\":\"message.router.systemRole\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:52\",\"parentId\":2,\"isShow\":1,\"path\":\"/role\",\"isFixedTag\":0,\"competence\":[\"root\",\"user\"],\"component\":\"system/role\",\"createTime\":\"2022-03-28T11:34:58\",\"isKeepAlive\":1,\"menuId\":4,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"ri-menu-fill\",\"orderNum\":3,\"updateUser\":null,\"menuName\":\"message.router.systemMenu\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:50\",\"parentId\":2,\"isShow\":1,\"path\":\"/menu\",\"isFixedTag\":0,\"competence\":[\"root\",\"user\"],\"component\":\"system/menu\",\"createTime\":\"2022-03-28T11:34:58\",\"isKeepAlive\":1,\"menuId\":5,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"ri-external-link-line\",\"orderNum\":6,\"updateUser\":null,\"menuName\":\"message.router.externalLink\",\"linkAddress\":\"https://element.eleme.cn/#/zh-CN\",\"remark\":null,\"updateTime\":\"2022-05-06T13:10:32\",\"parentId\":10,\"isShow\":1,\"path\":\"/link\",\"isFixedTag\":0,\"competence\":[\"root\",\"user\"],\"component\":\"layout/routerView/parent\",\"createTime\":\"2022-03-28T11:34:58\",\"isKeepAlive\":1,\"menuId\":17,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":1,\"query\":null,\"icon\":\"ri-link-m\",\"orderNum\":5,\"updateUser\":null,\"menuName\":\"message.router.layoutIframeView\",\"linkAddress\":\"https://hutool.cn/\",\"remark\":null,\"updateTime\":\"2022-05-06T13:10:34\",\"parentId\":10,\"isShow\":1,\"path\":\"/iframes\",\"isFixedTag\":0,\"competence\":[\"root\",\"user\"],\"component\":\"layout/routerView/parent\",\"createTime\":\"2022-03-28T11:34:58\",\"isKeepAlive\":1,\"menuId\":16,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"ri-barcode-box-line\",\"orderNum\":999,\"updateUser\":null,\"menuName\":\"Test\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:48\",\"parentId\":0,\"isShow\":1,\"path\":\"/fun\",\"isFixedTag\":0,\"competence\":[\"root\"],\"component\":\"layout/routerView/parent\",\"createTime\":\"2022-05-06T10:16:34\",\"isKeepAlive\":1,\"menuId\":10,\"menuType\":\"C\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"el-icon-edit\",\"orderNum\":0,\"updateUser\":null,\"menuName\":\"message.router.funSignCanvas\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:45\",\"parentId\":10,\"isShow\":1,\"path\":\"/signCanvas\",\"isFixedTag\":0,\"competence\":[\"root\"],\"component\":\"test/fun/signCanvas\",\"createTime\":\"2022-05-06T10:36:06\",\"isKeepAlive\":1,\"menuId\":11,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"el-icon-thumb\",\"orderNum\":1,\"updateUser\":null,\"menuName\":\"message.router.funTagsView\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:43\",\"parentId\":10,\"isShow\":1,\"path\":\"/fun/tagsView\",\"isFixedTag\":0,\"competence\":[\"root\"],\"component\":\"test/fun/tagsView\",\"createTime\":\"2022-05-06T10:44:29\",\"isKeepAlive\":1,\"menuId\":12,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"ri-game-line\",\"orderNum\":2,\"updateUser\":null,\"menuName\":\"message.router.pagesFormAdapt\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:42\",\"parentId\":10,\"isShow\":1,\"path\":\"/pages/formAdapt\",\"isFixedTag\":0,\"competence\":[\"root\"],\"component\":\"test/pages/formAdapt\",\"createTime\":\"2022-05-06T10:51:29\",\"isKeepAlive\":1,\"menuId\":13,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"ri-lightbulb-line\",\"orderNum\":3,\"updateUser\":null,\"menuName\":\"message.router.personal\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:39\",\"parentId\":10,\"isShow\":1,\"path\":\"/personal\",\"isFixedTag\":0,\"competence\":[\"root\"],\"component\":\"test/personal\",\"createTime\":\"2022-05-06T10:54:52\",\"isKeepAlive\":1,\"menuId\":14,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1},{\"isIframe\":0,\"query\":null,\"icon\":\"ri-surgical-mask-line\",\"orderNum\":4,\"updateUser\":null,\"menuName\":\"message.router.tools\",\"linkAddress\":null,\"remark\":null,\"updateTime\":\"2022-05-06T13:10:35\",\"parentId\":10,\"isShow\":1,\"path\":\"/tools\",\"isFixedTag\":0,\"competence\":[\"root\"],\"component\":\"test/tools\",\"createTime\":\"2022-05-06T10:56:13\",\"isKeepAlive\":1,\"menuId\":15,\"menuType\":\"M\",\"createUser\":\"admin\",\"state\":1}]}";
        JSONObject jsonObject = JSONObject.parseObject(treeStr, JSONObject.class);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id", "menuId");
        jsonObject1.put("label", "menuName");
        jsonObject1.put("parent", "parentId");
        System.out.println(getTree((List<Map<String, Object>>) jsonObject.get("data"), "0", jsonObject1));

    }

    /**
     * 生成tree形的数据构造json串(从给定的parentId在结果集中向下生成树)
     *
     * @param data     数据列表
     * @param parentId 父节点ID
     * @param field    节点字段映射配置
     * @return com.alibaba.fastjson.JSONArray
     * @author XianYao
     * @date 2022/5/9 11:31
     */
    public static JSONArray getTree(List<Map<String, Object>> data, String parentId, JSONObject field) {
        JSONArray ret = new JSONArray();
        if (data == null || data.size() == 0) {
            return ret;
        }
        if (parentId == null) {
            parentId = "0";
        }
        String idField = "id";
        String labelField = "label";
        String parentField = "parentId";

        if (!ObjectUtils.isEmpty(field)) {
            if (field.containsKey(ID)) {
                idField = field.getString(ID);
            }
            if (field.containsKey(LABEL)) {
                labelField = field.getString(LABEL);
            }
            if (field.containsKey(PARENT_ID)) {
                parentField = field.getString(PARENT_ID);
            }
        }
        Map<String, JSONObject> nodes = new HashMap<>(2);
        Map<String, JSONArray> child = new HashMap<>(2);
        for (Map<String, Object> map : data) {
            String id = getValue(map, idField, false).toString();
            String pId = getValue(map, parentField, false).toString();
            JSONObject node = genTreeNode(map, idField, labelField, parentField);
            nodes.put(id, node);
            //父节点已经解析过
            if (nodes.containsKey(pId)) {
                JSONObject pNode = nodes.get(pId);
                //还没有children属性
                if (!pNode.containsKey(CHILDREN)) {
                    //如是根节点，指向ret列表
                    pNode.put(CHILDREN, pId.equals(parentId) ? ret : new JSONArray());
                }
                //注册父子关系
                pNode.getJSONArray(CHILDREN).add(node);
            } else { //父节点还没遍历到，先放到child列表中
                if (!child.containsKey(pId)) {
                    //如是根节点，指向ret列表
                    child.put(pId, pId.equals(parentId) ? ret : new JSONArray());
                }
                child.get(pId).add(node);
            }
            //有子节点
            if (child.containsKey(id)) {
                node.put(CHILDREN, child.get(id));
                //移除子节点映射关系
                child.remove(id);
            }
        }
        return ret;
    }

    private static Object getValue(Map<String, Object> node, String key, boolean remove) {
        Object value = node.getOrDefault(key, node.getOrDefault(CommonTool.toHump(key), key.toLowerCase()));
        String parentId = "parent_id";
        //parent_id没取到，尝试驼峰键名获取
        if (value == null && parentId.equalsIgnoreCase(key)) {
            value = node.get("parentId");
            if (!ObjectUtils.isEmpty(value)) {
                //获取到了，把键名改成驼峰命名的parentId
                key = "parentId";
            }
        }
        if (remove) {
            node.remove(key);
            node.remove(key.toLowerCase());
        }
        return value == null ? "" : value;
    }

    private static JSONObject genTreeNode(Map<String, Object> map, String id, String name, String parent) {
        //复制一个副本，如果用原map删除属性可能会影响到缓存结果
        Map<String, Object> hashMap = new HashMap<>(map);
        JSONObject node = new JSONObject();
        node.put(ID, getValue(hashMap, id, true));
        node.put(LABEL, getValue(hashMap, name, true));
        node.put(PARENT_ID, getValue(hashMap, parent, true));
        Object expanded = getValue(hashMap, "expanded", true);
        //默认展开
        if (!ObjectUtils.isEmpty(expanded)) {
            node.put("expanded", "true".equals(expanded));
        }
        //默认选中
        Object checked = getValue(hashMap, "checked", true);
        if (!ObjectUtils.isEmpty(checked)) {
            node.put("checked", "true".equals(checked));
        }
        //设置禁用
        Object disabled = getValue(hashMap, "disabled", true);
        if (!ObjectUtils.isEmpty(disabled)) {
            node.put("disabled", "true".equals(disabled));
        }
        //设置图标
        Object icon = getValue(hashMap, "icon", true);
        if (!ObjectUtils.isEmpty(icon)) {
            node.put("icon", icon);
        }
        //其他参数
        if (!ObjectUtils.isEmpty(hashMap)) {
            node.put("attributes", hashMap);
        }
        return node;
    }

    static class TreeEntity {
        private String id;
        private String label;
        private String parentId;
        private List<Object> children;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public List<Object> getChildren() {
            return children;
        }

        public void setChildren(List<Object> children) {
            this.children = children;
        }
    }
}
