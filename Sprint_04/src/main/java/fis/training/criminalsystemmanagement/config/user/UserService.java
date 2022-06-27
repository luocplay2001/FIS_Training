package fis.training.criminalsystemmanagement.config.user;

import fis.training.criminalsystemmanagement.model.Detective;
import fis.training.criminalsystemmanagement.repository.DetectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private DetectiveRepository detectiveRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Detective detective = detectiveRepository.findByUsername(username);
        if (detective == null) {
            throw new UsernameNotFoundException(username);
        }
        return UserDetailsImpl.build(detective);
    }
}
