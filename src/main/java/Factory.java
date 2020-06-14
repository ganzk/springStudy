import com.track.domain.UserDo;

public class Factory {

    public static UserDo getuserDo(){
        return new UserDo("lisi",17);
    }

    public UserDo getUser(){
        return new UserDo("wangwu",16);
    }

}
