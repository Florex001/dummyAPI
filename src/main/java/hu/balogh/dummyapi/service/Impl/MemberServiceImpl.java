package hu.balogh.dummyapi.service.Impl;

import hu.balogh.dummyapi.controller.dto.MembersDto;
import hu.balogh.dummyapi.controller.dto.MembersPostDto;
import hu.balogh.dummyapi.mapper.MemberMapper;
import hu.balogh.dummyapi.repository.MemberRepository;
import hu.balogh.dummyapi.repository.entity.MemberEntity;
import hu.balogh.dummyapi.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    private static final Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    private MemberRepository membersRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    @Override
    public void createMember(MembersPostDto membersPostDto) {
        MemberEntity membersEntity = MemberMapper.INSTANCE.toEntityPost(membersPostDto);
        membersRepository.save(membersEntity);
        logger.info("Sikeresen mentve a member.");
    }

    @Override
    public List<MembersDto> getAllMembers() {
        List<MemberEntity> membersEntity = membersRepository.findAll();
        logger.info("Sikeresen lekérdezve az összes member.");
        return MemberMapper.INSTANCE.toDtoList(membersEntity);
    }

    @Override
    public void deleteMembers(int id) {
        membersRepository.deleteById(id);
        logger.info("Sikeresen törölve a member: {}", id);
    }
}
