package com.deutsche.telco.service.impl;

import com.deutsche.telco.constants.StringConstants;
import com.deutsche.telco.dto.OtpVerifyRequestDto;
import com.deutsche.telco.exceptions.OtpNotFoundException;
import com.deutsche.telco.model.Otp;
import com.deutsche.telco.model.User;
import com.deutsche.telco.repository.OtpRepository;
import com.deutsche.telco.repository.UserRepository;
import com.deutsche.telco.service.OtpService;
import com.deutsche.telco.utils.DateUtil;
import com.deutsche.telco.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public String sendOtpToEmail(User user) {
//        int otp = (int) (Math.random() * 9000) + 1000;
//        String otpSent = sendOtpEmail(user, otp);
//        if(otpSent.equals("OTP not sent"))
//            return otpSent;
//        Otp otpGenerator = new Otp();
//        otpGenerator.setOtp((long) otp);
//        otpGenerator.setEmail(user.getEmail());
//        otpGenerator.setUserId((long) user.getId());
//        otpGenerator.setExpiryTime(DateUtil.addMinutesToCurrentTimeStamp(StringConstants.OTP_EXPIRY_TIME_MINUTES));
//        otpGenerator.setIsActive(true);
//        otpRepository.save(otpGenerator);
//        return otpSent;
        return null;
    }

    @Override
    public String sendOtpEmail(User user, int otp){
//        try{
//            SimpleMailMessage msg = new SimpleMailMessage();
//            msg.setFrom("deutschetelco@gmail.com");
//            msg.setTo(user.getEmail());
//            msg.setSubject("Deutsche Telco OTP Verification");
//            msg.setText("Hello "+ user.getName()+ ",\n\n" +"Your Login OTP is: " + otp + "\n"+ "Please Verify. \n\n"+"Regards \n"+"Deutsche Telco");
//            javaMailSender.send(msg);
//            return "OTP sent";
//        }catch (Exception e) {
//            e.printStackTrace();
//            return "OTP not sent";
//        }
        return null;
    }

    @Override
    public String verifyOtp(OtpVerifyRequestDto otpVerifyRequestDto) {
//        Long otp = otpVerifyRequestDto.getOtp();
//        String email = otpVerifyRequestDto.getEmail();
//
//        Page<Otp> otpPage = otpRepository.findLatestByOtpAndEmail(otp, email, PageRequest.of(0, 1));
//
//        if (!otpPage.hasContent()) {
//            throw new OtpNotFoundException("No OTP record found for otp: " + otp + " and email: " + email);
//        }
//        Timestamp end = otpPage.getContent().get(0).getExpiryTime();
//        Timestamp start = new Timestamp(System.currentTimeMillis());
//        if(//DateUtil.getTimeStampDiffInMin(start, end)>=0 &&
//                DateUtil.getTimeStampDiffInMin(start, end)<=2){
//     //       return jwtUtil.generateToken(otpPage.getContent().get(0));
//        }
        return null;
    }

}
