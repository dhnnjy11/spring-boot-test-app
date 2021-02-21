package com.textapp.cacheabledata.service;

import com.textapp.cacheabledata.entity.Student;
import com.textapp.cacheabledata.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {

    public String getAllTeachers() {

        ArrayList<Integer> rows = new ArrayList<>();
        for (int i = 0; i < 1000;  i++){
         rows.add(i);
        }
        log.info("start time : " + System.currentTimeMillis());
        rows.parallelStream().forEach(x->{
            System.out.print(x);
        });
        log.info("end time : " + System.currentTimeMillis());
        return "OK";
    }

    public String sendMeetingMail() throws ExecutionException, InterruptedException {
        CompletableFuture<String> result1 = CompletableFuture.supplyAsync(this::sendMailToAdmin) ;
        CompletableFuture<Void> result2 = CompletableFuture.runAsync(this::sendMailToStudent) ;
        return result1.get() + " " + result2.get();
    }

    String sendMailToAdmin() {
        try{
            log.info(Thread.currentThread().getName());
            Thread.sleep(2*1000);
            log.info("mail has been send to admin");
            return "Mail Send to Admin";
        }
        catch (Exception ex){
            log.error(ex.getMessage());
        }
        return "Nothing";
    }

    void sendMailToStudent(){
        try{
            log.info(Thread.currentThread().getName());
            Thread.sleep(2*1000);
            log.info("mail has been send to student");
        }
        catch (Exception ex){
            log.error(ex.getMessage());
        }

    }
}
