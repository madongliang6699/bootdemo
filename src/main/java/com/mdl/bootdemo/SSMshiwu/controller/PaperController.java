package com.mdl.bootdemo.SSMshiwu.controller;

import com.mdl.bootdemo.SSMshiwu.entity.Paper;
import com.mdl.bootdemo.SSMshiwu.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

/**
 * @author ：madongliang
 * @date ：Created in 2019/7/27 1:45
 * @description： 格言：每天生活工作都要全力以赴，绝不偷懒！（尽量吧） 决定一个人的一生以及整个命运的，是日积月累的努力！
 */
//@RequestMapping("/paper")
@Controller
public class PaperController {
    @Autowired
    private PaperService paperService;

    /**
     * 查询所有
     */
    @ResponseBody
    @RequestMapping(value = "/allPaper", produces = "application/json; charset=utf-8")
    public Object list() {
        List<Paper> list = paperService.queryAllPaper();
        System.out.println(list.toString());
        return list.toString();
    }


    /**
     * 添加一条
     */
    @RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addPaper() {
        Random rand = new Random();
        Paper paper = new Paper();
        paper.setPaperDetail("haha");
        paper.setPaperName("我的书名字");
        paper.setPaperNum(rand.nextInt(100) + 1);
        int i = paperService.addPaper(paper);
        return "插入一条数据 id是："+i;
    }

    /**
     * 删除一条
     */
    @RequestMapping(value = "/del/{paperId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deletePaper(@PathVariable("paperId") Long id) {
        paperService.deletePaperById(id);
        return "删除一条数据id是"+id;
    }


    /**
     * 修改一条
     */
    @RequestMapping(value = "/update/{id}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updatePaper(@PathVariable("id") Long id) {
        Random rand = new Random();
        Paper paper = new Paper();
        paper.setPaperDetail("haha");
        paper.setPaperId(id);
        paper.setPaperName("我的书名字");
        paper.setPaperNum(rand.nextInt(100) + 1);
        paperService.updatePaper(paper);
        //paper = paperService.queryById(paper.getPaperId());
        return "修改了一条数据id是："+id;
    }

    /**
     * 插入一条，修改一条
     */
    @RequestMapping(value = "/addupdate/{id}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addupdatePaper(@PathVariable("id") Long id) {
        Random rand = new Random();

        Paper paper1 = new Paper();
        paper1.setPaperDetail("haha");
        paper1.setPaperName("我的书名字");
        paper1.setPaperNum(rand.nextInt(100) + 1);

        Paper paper2 = new Paper();
        paper2.setPaperDetail("haha");
        paper2.setPaperId(id);
        paper2.setPaperName("我的书名字");
        paper2.setPaperNum(rand.nextInt(100) + 1);

        String s = paperService.addupdatePaper(paper1,paper2);
        return s;
    }

}
