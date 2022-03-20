package net.minecraft.command;

import net.minecraft.util.BlockPos;

import java.util.List;

public interface ICommand extends Comparable {
    String getCommandName();

    String getCommandUsage(ICommandSender sender);

    List getCommandAliases();

    void processCommand(ICommandSender sender, String[] args) throws CommandException;

    /**
     * Returns true if the given command sender is allowed to use this command.
     */
    boolean canCommandSenderUseCommand(ICommandSender sender);

    List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos);

    /**
     * Return whether the specified command parameter index is a username
     * parameter.
     */
    boolean isUsernameIndex(String[] args, int index);
}
