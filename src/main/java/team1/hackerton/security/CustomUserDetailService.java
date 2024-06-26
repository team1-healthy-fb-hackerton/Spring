package team1.hackerton.security;


import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team1.hackerton.domain.Member;
import team1.hackerton.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    public CustomUserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException{
        Member member = memberRepository.findById(Long.parseLong(memberId))
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저가 없습니다."));
        CustomUserInfo dto = modelMapper.map(member, CustomUserInfo.class);
        return new CustomUserDetails(dto);
    }
}
