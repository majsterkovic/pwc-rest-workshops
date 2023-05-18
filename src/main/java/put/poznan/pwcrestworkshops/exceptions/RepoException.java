package put.poznan.pwcrestworkshops.exceptions;

public class RepoException extends RuntimeException {

    public RepoException(String notFound) {
        super(notFound);
    }
}
