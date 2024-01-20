package study.employment.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.employment.dto.MemberDto;
import study.employment.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApiController {

  private final MemberService memberService;

  @PostMapping("/sign-up")
  public ResponseEntity<?> signUp(@RequestBody final MemberDto memberDto) {
    return ResponseEntity.ok().body(memberService.signUp(memberDto));
  }

  @PostMapping("/sign-in")
  public ResponseEntity<?> signIn(@RequestBody final MemberDto memberDto) {
    memberService.signIn(memberDto);

    return ResponseEntity.ok().body(memberDto);
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody final MemberDto memberDto) {

    return ResponseEntity.ok().body(memberService.update(memberDto));
  }

  @DeleteMapping("/remove")
  public void remove(@RequestBody final MemberDto memberDto) {
    memberService.remove(memberDto);
  }

  @GetMapping("/find/{memberId}")
  public ResponseEntity<?> findById(@PathVariable(value = "memberId") final Long id) {

    return ResponseEntity.ok().body(memberService.findById(id));
  }

  @GetMapping("/find-all/user")
  public ResponseEntity<?> findAll() {

    return ResponseEntity.ok().body(memberService.findAll());
  }
}
