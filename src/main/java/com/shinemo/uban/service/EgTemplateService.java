package com.shinemo.uban.service;

import com.shinemo.uban.config.EgConstant;
import com.shinemo.uban.param.Result;
import com.shinemo.uban.param.TemplateParam;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 12:02
 */
public class EgTemplateService extends BaseService {

    /**
     * 添加短信模板
     *
     * @param templateParam
     * @return
     * @throws Exception
     */
    public Result add(TemplateParam templateParam) throws Exception {
        return invoke(templateParam, EgConstant.ADD_TEMPLATE_URI);
    }

    /**
     * 删除短信模板
     *
     * @param templateParam
     * @return
     * @throws Exception
     */
    public Result del(TemplateParam templateParam) throws Exception {
        return invoke(templateParam, EgConstant.DEL_TEMPLATE_URI);
    }
}
