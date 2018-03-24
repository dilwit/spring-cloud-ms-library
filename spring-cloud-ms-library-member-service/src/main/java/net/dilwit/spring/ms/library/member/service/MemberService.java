package net.dilwit.spring.ms.library.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dilwit.spring.ms.library.member.controller.vm.RegistrationVM;
import net.dilwit.spring.ms.library.member.domain.Member;
import net.dilwit.spring.ms.library.member.repo.MemberRepo;
import net.dilwit.spring.ms.library.member.service.feign.PaymentServiceClient;
import net.dilwit.spring.ms.library.member.service.i.IMeberService;

@Service
public class MemberService implements IMeberService {
	
	@Autowired
	PaymentServiceClient paymentServiceClient;
	
	@Autowired
	private MemberRepo memberRepo;

	@Override
	public void register(RegistrationVM registrationVM) {
		
		// Step 1: Process payment
		paymentServiceClient.pay();
		
		// Step 2: Upon payment confirmation, member registration
		Member member = new Member(registrationVM.getFirstName(), registrationVM.getLastName(), registrationVM.getEmailAddress());
		memberRepo.save(member);
	}

}
