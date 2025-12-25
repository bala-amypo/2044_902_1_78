@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // TEMP hardcoded (college-level is fine)
        return User.builder()
                .username(username)
                .password("{noop}password")
                .roles("USER") // or ADMIN
                .build();
    }
}
