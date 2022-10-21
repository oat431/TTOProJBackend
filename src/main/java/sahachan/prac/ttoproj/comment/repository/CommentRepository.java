package sahachan.prac.ttoproj.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sahachan.prac.ttoproj.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
