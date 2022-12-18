package iostream;

import java.util.List;

public interface ScoreInterface {
    
    public void write(ScoreVo vo);
    public List<ScoreVo> read();
    public void modify(ScoreVo vo);
    public void delete(int serial);
    
}
