#! /usr/bin/env ruby

if ARGV.length != 1 then
  puts "Usage: tetris.rb <iterations>"
  exit 1
end

def gen_permutation
  pieces = ['I','J','L','T','O','S','Z']
  (2..7).each do |i|
    i = 8 - i
    index = rand(i)
    temp = pieces[index]
    pieces[index] = pieces[i]
    pieces[i] = temp
  end

  pieces
end

iterations = ARGV[0].to_i
out = []

iterations.times do
  p = gen_permutation
  out << p
end

puts out.join ""
