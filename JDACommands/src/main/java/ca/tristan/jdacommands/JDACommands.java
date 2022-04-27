package ca.tristan.jdacommands;

import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.hooks.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class JDACommands extends ListenerAdapter {

    private ArrayList<ICommandExecutor> commands = new ArrayList<>();

    private final String prefix;

    public String getPrefix(){
        return prefix;
    }

    public JDACommands(String prefix){
        this.prefix = prefix;
    }

    public ArrayList<ICommandExecutor> getCommands(){
        return commands;
    }

    public void setCommands(ArrayList<ICommandExecutor> commands){
        this.commands = commands;
    }

    public void registerCommand(ICommandExecutor command){
        this.commands.add(command);
    }

    private void init(MessageReceivedEvent event){
        for (ICommandExecutor command : this.commands) {
            if(event.getMessage().getContentRaw().split(" ")[0].equalsIgnoreCase(prefix + command.getName())){
                if(command.needOwner()){
                    if(event.getMember().isOwner()){
                        command.execute(new Command(event));
                    }
                }else{
                    if(command.canUse(event.getGuild()).equals(event.getGuild().getPublicRole())){
                        command.execute(new Command(event));
                        return;
                    }
                    if(Objects.requireNonNull(event.getMember()).getRoles().contains(command.canUse(event.getGuild()))){
                        command.execute(new Command(event));
                    }else{
                        event.getChannel().sendMessage("You don't have the required permissions to use this command.").queue();
                    }
                }
            }
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().startsWith(prefix)){
            init(event);
        }
    }
}
