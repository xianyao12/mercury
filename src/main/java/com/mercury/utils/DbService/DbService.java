package com.mercury.utils.DbService;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author XianYao
 * @version V1.0.0
 * @date 2022/5/20 12:45
 */
interface DbService {
    /**
     * 查询List数据
     *
     * @param mapperId mapperId
     * @return List<T>
     * @throws Exception 异常
     */
    <T> List<T> selectList(String mapperId) throws Exception;

    /**
     * 查询List数据
     *
     * @param mapperId mapperId
     * @param dbName   数据库名称
     * @return List<T>
     * @throws Exception 异常
     */
    <T> List<T> selectList(String mapperId, String dbName) throws Exception;

    /**
     * 查询List数据
     *
     * @param mapperId mapperId
     * @param rb       分页
     * @return List<T>
     * @throws Exception 异常
     */
    <T> List<T> selectList(String mapperId, RowBounds rb) throws Exception;

    /**
     * 查询List数据
     *
     * @param mapperId mapperId
     * @param param    参数
     * @return List<T>
     * @throws Exception 异常
     */
    <T> List<T> selectList(String mapperId, Object param) throws Exception;

    /**
     * 查询List数据
     *
     * @param mapperId mapperId
     * @param rb       分页
     * @param dbName   数据库名称
     * @return List<T>
     * @throws Exception 异常
     */
    <T> List<T> selectList(String mapperId, RowBounds rb, String dbName) throws Exception;

    /**
     * 查询List数据
     *
     * @param mapperId mapperId
     * @param param    参数
     * @param rb       分页
     * @return List<T>
     * @throws Exception 异常
     */
    <T> List<T> selectList(String mapperId, Object param, RowBounds rb) throws Exception;

    /**
     * 查询List数据
     *
     * @param mapperId mapperId
     * @param param    参数
     * @param dbName   数据库名称
     * @return List<T>
     * @throws Exception 异常
     */
    <T> List<T> selectList(String mapperId, Object param, String dbName) throws Exception;

    /**
     * 查询List数据
     *
     * @param mapperId mapperId
     * @param param    参数
     * @param rb       分页
     * @param dbName   数据库名称
     * @return List<T>
     * @throws Exception 异常
     */
    <T> List<T> selectList(String mapperId, Object param, RowBounds rb, String dbName) throws Exception;

    //================================================================================================================//

    <T> T selectOne(String mapperId) throws Exception;

    <T> T selectOne(String mapperId, Object param) throws Exception;

    <T> T selectOne(String mapperId, String dbName) throws Exception;

    <T> T selectOne(String mapperId, Object param, String dbName) throws Exception;

    //================================================================================================================//

    List<Map<String, Object>> queryForList(String sql, Object... args) throws Exception;

    List<Map<String, Object>> queryForList(String sql, String dbName, Object... args) throws Exception;

    //================================================================================================================//

    <T> List<T> queryForList(String sql, Class<T> elementType, Object... args) throws Exception;

    <T> List<T> queryForList(String sql, Class<T> elementType, String dbName, Object... args) throws Exception;

    //================================================================================================================//

    Map<String, Object> queryForMap(String sql, Object... args) throws Exception;

    Map<String, Object> queryForMap(String sql, String dbName, Object... args) throws Exception;

    //================================================================================================================//

    <T> T queryForObject(String sql, Class<T> requiredType, Object... args) throws Exception;

    <T> T queryForObject(String sql, Class<T> requiredType, String dbName, Object... args) throws Exception;

    //================================================================================================================//

    void modify(String mapperId) throws Exception;

    void modify(String mapperId, Object param) throws Exception;

    void modify(String mapperId, String dbName) throws Exception;

    void modify(String mapperId, Object param, String dbName) throws Exception;

    //================================================================================================================//

    void modify(String mapperId, List<Object> params) throws Exception;

    void modify(String mapperId, List<Object> params, String dbName) throws Exception;

    //================================================================================================================//

    void modify(List<Object> mappers, List<Object> params) throws Exception;

    void modify(List<Object> mappers, List<Object> params, String dbName) throws Exception;

    //================================================================================================================//

    void modify(List<String> mappers) throws Exception;

    void modify(List<String> mappers, String dbName) throws Exception;

    void modify(List<String> mappers, Object param) throws Exception;

    void modify(List<String> mappers, Object param, String dbName) throws Exception;

    //================================================================================================================//

    void execProc(String mapperId) throws Exception;

    void execProc(String mapperId, Object param) throws Exception;

    void execProc(String mapperId, String dbName) throws Exception;

    void execProc(String mapperId, Object param, String dbName) throws Exception;

    //================================================================================================================//

    JdbcTemplate getJdbcTemplate();

    JdbcTemplate getJdbcTemplate(String name);

    //================================================================================================================//

    SqlSessionTemplate getSqlSessionTemplate();

    SqlSessionTemplate getSqlSessionTemplate(String name);
}
