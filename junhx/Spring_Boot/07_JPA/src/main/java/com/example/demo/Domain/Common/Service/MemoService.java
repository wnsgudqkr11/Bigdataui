package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Dao.MemoDao;
import com.example.demo.Domain.Common.Dto.MemoDto;
import com.example.demo.Domain.Common.Entity.Memo;
import com.example.demo.Domain.Common.Repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemoService {
    @Autowired
    private MemoDao memoDao;

    @Autowired
    private MemoRepository memoRepository;


    public boolean memoRegistration(MemoDto dto) throws Exception {
        int result = memoDao.insert(dto);
        return result>0;
    }

    public Long memoRegistraton2(MemoDto dto) throws Exception{
        // dto -> entity
        Memo memo = Memo.builder()
                .id(null)
                .text(dto.getText())
                .writer(dto.getWriter())
                .createAt(LocalDateTime.now())
                .build();
        memoRepository.save(memo);
        return memo.getId();
    }
}