package com.besafe.besafebackend.controllers;

import com.besafe.besafebackend.modals.Classes.Authentication.Utils;
import com.besafe.besafebackend.modals.Classes.Authentication.VerifyOtpRequest;
import com.besafe.besafebackend.modals.Classes.Authentication.VerifyOtpResult;
import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;
import com.besafe.besafebackend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    Utils utils;

    @PutMapping("/otp/send/{userId}")
    public ResultImpl sendOtp(@PathVariable String userId){
        ResultImpl sendotpResult = new ResultImpl(1, "Failure");
        try{
            int newOtp = Utils.generateOtp();
            String otpHash = utils.convertToHash(String.valueOf(newOtp));
            boolean emailSent = utils.sendEmail(userId,"Signup to BeSafe OTP verification","Your one time password is "+newOtp);
            boolean daoResult = authenticationService.storeOtpHash(userId, otpHash);
            if(daoResult==false){
                return sendotpResult;
            }
            sendotpResult.setErrorCode(0);
            sendotpResult.setErrorMessage("Success");
            return sendotpResult;
        }
        catch(Exception e){
            return sendotpResult;
        }
    }

    @GetMapping("/otp/verify")
    public VerifyOtpResult verifyUserOtp(@RequestBody VerifyOtpRequest verifyOtpRequest){
        VerifyOtpResult verifyOtpResult = new VerifyOtpResult(1, "Failure");

        try{
            return verifyOtpResult;
        }
        catch(Exception e){
            return verifyOtpResult;
        }
    }
}
