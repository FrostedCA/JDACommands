package ca.tristan.jdacommands;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.*;

public class Command {

    private final TextChannel textChannel;
    private final Member selfMember;
    private final Member member;
    private final Member commandSender;
    private final Guild guild;
    private final JDA jda;
    private final Message message;
    private final String[] args;
    private final GuildVoiceState selfVoiceState;
    private final GuildVoiceState memberVoiceState;

    protected Command(MessageReceivedEvent event){
        this.textChannel = event.getTextChannel();
        this.member = event.getMember();
        this.guild = event.getGuild();
        this.jda = event.getJDA();
        this.message = event.getMessage();

        this.commandSender = member;
        this.selfMember = guild.getSelfMember();
        this.args = message.getContentRaw().split(" ");
        this.selfVoiceState = selfMember.getVoiceState();
        this.memberVoiceState = member.getVoiceState();
    }

    public TextChannel getTextChannel() {
        return textChannel;
    }

    public Member getSelfMember() {
        return selfMember;
    }

    public Member getCommandSender() { return commandSender; }

    public Member getMember() {
        return member;
    }

    public Guild getGuild() {
        return guild;
    }

    public JDA getJda() {
        return jda;
    }

    public Message getMessage() {
        return message;
    }

    public String[] getArgs() {
        return args;
    }

    public GuildVoiceState getSelfVoiceState() {
        return selfVoiceState;
    }

    public GuildVoiceState getMemberVoiceState() {
        return memberVoiceState;
    }
}
