package com.fangshaolei.wiki.service;

import com.fangshaolei.wiki.domain.Ebook;
import com.fangshaolei.wiki.domain.EbookExample;
import com.fangshaolei.wiki.mapper.EbookMapper;
import com.fangshaolei.wiki.req.EbookReq;
import com.fangshaolei.wiki.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName EbookService
 * @Description
 * @createTime 2022/06/07 22:32
 **/
@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;
    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/7 22:54
      * @params: 
      * @return: 
      **/
    public List<EbookResp> list(EbookReq req){
        EbookExample example = new EbookExample();
        EbookExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(example);
        // 进行转换
        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook, ebookResp);
            respList.add(ebookResp);
        }
        return respList;
    }
}