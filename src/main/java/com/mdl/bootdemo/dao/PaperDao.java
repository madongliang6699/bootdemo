package com.mdl.bootdemo.dao;


import com.mdl.bootdemo.entity.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：madongliang
 * @date ：Created in 2019/7/27 1:23
 * @description：
 */
@Repository
public interface PaperDao {
    int addPaper(Paper paper);

    int deletePaperById(long id);

    int updatePaper(Paper paper);

    Paper queryById(long id);

    List<Paper> queryAllPaper();
}
