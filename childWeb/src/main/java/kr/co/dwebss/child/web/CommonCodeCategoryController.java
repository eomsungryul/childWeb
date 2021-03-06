package kr.co.dwebss.child.web;
import kr.co.dwebss.child.core.Result;
import kr.co.dwebss.child.core.ResultGenerator;
import kr.co.dwebss.child.model.CommonCodeCategory;
import kr.co.dwebss.child.service.CommonCodeCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@RestController
@RequestMapping("/common/code/category")
public class CommonCodeCategoryController {
    @Resource
    private CommonCodeCategoryService commonCodeCategoryService;

    @PostMapping("/add")
    public Result add(CommonCodeCategory commonCodeCategory) {
        commonCodeCategoryService.save(commonCodeCategory);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        commonCodeCategoryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(CommonCodeCategory commonCodeCategory) {
        commonCodeCategoryService.update(commonCodeCategory);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        CommonCodeCategory commonCodeCategory = commonCodeCategoryService.findById(id);
        return ResultGenerator.genSuccessResult(commonCodeCategory);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CommonCodeCategory> list = commonCodeCategoryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
