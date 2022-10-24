package sahachan.prac.ttoproj.comment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sahachan.prac.ttoproj.comment.entity.Comment;
import sahachan.prac.ttoproj.comment.repository.CommentRepository;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

}
