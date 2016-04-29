package com.ldexin.learning;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class RunCmd{
	private final Options options = new Options();

	public CommandLine parseInputArgs(String[] args)throws ParseException{
		OptionGroup optionGroup = new OptionGroup();
        	Option help = new Option("help", "print this message");
		Option cmd = OptionBuilder.withArgName("cmd").hasArg(true).withDescription("The test command").create("cmd");
		options.addOption(cmd);
		CommandLineParser parser = new GnuParser();
		CommandLine line = parser.parse(options, args);
		return line;
	}

	public static void main(String[] args) {
		RunCmd cmd = new RunCmd();
		String command="";
		try{
			CommandLine line = cmd.parseInputArgs(args);
			command = line.getOptionValue("cmd");
		}catch (ParseException e){
			System.out.println("Parsing failed. Reason: " + e.getMessage() + "See \"RunCmd -help \"");
		}
		System.out.println("cmd:"+command);
		//invoke your class here
	}
}
