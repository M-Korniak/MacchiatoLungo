package declaration;

import program.ProgramData;

public abstract class Declaration {
    public abstract void execute(ProgramData programData) throws Exception;
    public abstract void pop(ProgramData programData);
}
